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
 
@Repository 
@Mapper 
public interface VentasDAO {

	@Select("Select id_venta,id_cliente,id_vendedor,DNI,NombreCompleto,PrecioProd,cantidad,Tipo,Serie,Numero from Ventas") 
	public List<Ventas> SelectALL(); 
 
	@Select("Select id_venta,id_cliente,id_vendedor,DNI,NombreCompleto,PrecioProd,cantidad,Tipo,Serie,Numero from Ventas where id_venta= #{id_venta} ") 
	public Ventas SelectById(Ventas ventas); 
 
	@Insert("insert into Ventas(id_cliente,id_vendedor,DNI,NombreCompleto,PrecioProd,cantidad,Tipo,Serie,Numero) values(#{id_cliente},#{id_vendedor},#{DNI},#{NombreCompleto},#{PrecioProd},#{cantidad},#{Tipo},#{Serie},#{Numero})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_venta",keyProperty ="id_venta" )
	public void Register(Ventas ventas ); 
 
	@Update("update Ventas set id_cliente=#{id_cliente},id_vendedor=#{id_vendedor},DNI=#{DNI},NombreCompleto=#{NombreCompleto},PrecioProd=#{PrecioProd},cantidad=#{cantidad},Tipo=#{Tipo},Serie=#{Serie},Numero=#{Numero} where id_venta= #{id_venta} ") 
	public void Update(Ventas ventas);
 
 }
