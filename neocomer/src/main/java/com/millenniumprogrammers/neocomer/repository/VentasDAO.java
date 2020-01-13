package com.millenniumprogrammers.neocomer.repository;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Ventas;
import com.millenniumprogrammers.neocomer.model.innerjoin.ReporteVendedor;
import com.millenniumprogrammers.neocomer.model.innerjoin.VentasInnerJoin;
import com.millenniumprogrammers.neocomer.model.innerjoin.VentasInnerJoinPedido;

@Repository
@Mapper
public interface VentasDAO {

	/*
	 * @Select("Select id_venta,id_cliente,id_vendedor,DNI,NombreCompleto,PrecioProd,cantidad,Tipo,Serie,Numero from Ventas"
	 * ) public List<Ventas> SelectALL();
	 */

	@Select("Select id_venta,id_cliente,id_vendedor,DNI,NombreCompleto,PrecioProd,cantidad,Tipo,Serie,Numero "
			+ "from Ventas where id_venta= #{id_venta} " + "order by FechaEmision desc")
	public Ventas SelectById(Ventas ventas);

	@Insert("insert into Ventas(id_cliente,id_vendedor,DNI,NombreCompleto,FechaEmision,EstadoApp) "
			+ "values(#{id_cliente},#{id_vendedor},#{DNI},#{NombreCompleto},getdate(),#{EstadoApp})")
	@Options(useGeneratedKeys = true, keyColumn = "id_venta", keyProperty = "id_venta")
	public void Register(Ventas ventas);

	@Update("update Ventas set Serie = #{Serie},Numero = #{Numero} ,EstadoApp = #{EstadoApp} where id_venta= #{id_venta} ")
	public void Update(Ventas ventas);// Actualizar Ventas Serie y numero

	@Update("update Ventas set EstadoApp ='C' where id_venta = #{id_venta} and id_cliente = #{id_cliente}")
	public void Cancelar(Ventas ventas);

	@Update("update Ventas set EstadoApp ='E' where id_venta = #{id_venta} and id_cliente = #{id_cliente}")
	public void Pagar(Ventas ventas);
	
	@Update("update Ventas set EstadoApp ='A' where id_venta = #{id_venta} and id_vendedor = #{id_cliente}")
	public void AceptarPedido(Ventas ventas);

	// C = Cancelado
	// P = Pendiente
	// E = Entregado
	// A = Aceptado

	@Select("select venta.id_venta,puesto.Detalle as nombrecomercio,foto.foto,(SELECT SUM(precioproducto * cantidad)from Detalle_Venta WHERE id_venta = venta.id_venta)as total,venta.FechaEmision as fechaEmision,venta.EstadoApp from ventas venta "
			+ "inner join vendedores vendedor on venta.id_vendedor = vendedor.id_vendedor "
			+ "inner join puestos puesto on puesto.id_puesto = vendedor.id_puesto "
			+ "inner join FotosPuesto foto on puesto.id_puesto = foto.id_puesto where venta.id_cliente = #{id_cliente} order by venta.id_venta desc")
	public List<VentasInnerJoin> getHistoriaPedidos(int id_cliente);

	@Select("select cliente.foto,venta.FechaEmision,venta.NombreCompleto,venta.id_venta,venta.DNI,(select sum(precioproducto*cantidad) from Detalle_Venta where id_venta= venta.id_venta) as total from Ventas venta \n" + 
			"inner join Clientes cliente \n" + 
			"on venta.id_cliente= cliente.id_cliente\n" + 
			"where venta.id_vendedor = #{id_vendedor} and venta.EstadoApp = 'P'")
	public List<VentasInnerJoinPedido>getPedidosporVendedor(int id_vendedor);
	
	@Select("select * from Ventas where id_venta = #{id_venta}")
	public Ventas cabeceraventa(int id_venta);
	
	@Select("select id_vendedor,count(distinct(DNI))AS clientes,sum(cantidad*precioproducto) gananciaTotal,(select SUM(detventa.precioproducto*detventa.cantidad) from Ventas venta INNER join Detalle_Venta detventa on venta.id_venta = detventa.id_venta where CONVERT(VARCHAR(10),venta.FechaEmision,111)=CONVERT(VARCHAR(10), getdate(), 111) and id_vendedor = #{id_vendedor} and venta.EstadoApp='E' GROUP by venta.id_vendedor) as gananciaHoy from Ventas venta inner join Detalle_Venta detventa on venta.id_venta = detventa.id_venta where id_vendedor = #{id_vendedor} group by id_vendedor ")
	public ReporteVendedor getreporte(int id_vendedor);
}
