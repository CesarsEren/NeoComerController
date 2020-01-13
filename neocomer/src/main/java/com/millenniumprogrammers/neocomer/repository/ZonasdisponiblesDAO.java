package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;

import com.millenniumprogrammers.neocomer.model.Ubicaciones;
import com.millenniumprogrammers.neocomer.model.Zonasdisponibles;
import com.millenniumprogrammers.neocomer.model.innerjoin.UbicacionesInnerJoin; 
 
@Repository 
@Mapper 
public interface ZonasdisponiblesDAO {

	@Select("Select id_zona,Apodo,longitud,latitud,estado from Zonasdisponibles") 
	public List<Zonasdisponibles> SelectALL(); 
 
	@Select("Select id_zona,Apodo,longitud,latitud,estado from Zonasdisponibles where id_zona= #{id_zona}") 
	public Zonasdisponibles SelectById(Zonasdisponibles zonasdisponibles); 
 
	@Select("Select id_zona,Apodo,longitud,latitud,estado from Zonasdisponibles where estado = 0") 
	public List<Zonasdisponibles> SelectNoActiveZone(Ubicaciones ubicaciones); 
	
	@Select("select vendedor.id_vendedor,puesto.Detalle,puesto.Referencia,zona.Apodo,zona.longitud,zona.latitud,fotopuesto.foto,(SELECT AVG(precio) as promedio FROM PRODUCTOS where idvendedor = vendedor.id_vendedor) as preciopromedio from Puestos puesto\n" + 
			"inner join Vendedores vendedor\n" + 
			"on vendedor.id_puesto = puesto.id_puesto\n" + 
			"inner join Permisos permiso\n" + 
			"on vendedor.id_permiso = permiso.id_permiso\n" + 
			"inner join ZonasDisponibles zona\n" + 
			"on permiso.id_zona = zona.id_zona\n" + 
			"inner join FotosPuesto fotopuesto\n" + 
			"on fotopuesto.id_puesto = puesto.id_puesto\n" + 
			"where zona.estado = 0 and permiso.estado = 1")
	public List<UbicacionesInnerJoin> SelectUbicacionesInnerJoin(UbicacionesInnerJoin ubicacionesInnerJoin);
	
	@Select("select vendedor.id_vendedor,puesto.Detalle,puesto.Referencia,zona.Apodo,zona.longitud,zona.latitud,fotopuesto.foto,(SELECT AVG(precio) as promedio FROM PRODUCTOS where idvendedor = vendedor.id_vendedor) as preciopromedio from Puestos puesto\n" + 
			"inner join Vendedores vendedor\n" + 
			"on vendedor.id_puesto = puesto.id_puesto\n" + 
			"inner join Permisos permiso\n" + 
			"on vendedor.id_permiso = permiso.id_permiso\n" + 
			"inner join ZonasDisponibles zona\n" + 
			"on permiso.id_zona = zona.id_zona\n" + 
			"inner join FotosPuesto fotopuesto\n" + 
			"on fotopuesto.id_puesto = puesto.id_puesto\n" + 
			"where zona.estado = 0 and permiso.estado = 1 and puesto.referencia = #{referencia}")
	public List<UbicacionesInnerJoin> SelectUbicacionesInnerJoinPorCategoria(String referencia);//categoria
	
	@Select("select vendedor.id_vendedor,puesto.Detalle,puesto.Referencia,zona.Apodo,zona.longitud,zona.latitud,fotopuesto.foto,(SELECT AVG(precio) as promedio FROM PRODUCTOS where idvendedor = vendedor.id_vendedor) as preciopromedio from Puestos puesto\n" + 
			"inner join Vendedores vendedor\n" + 
			"on vendedor.id_puesto = puesto.id_puesto\n" + 
			"inner join Permisos permiso\n" + 
			"on vendedor.id_permiso = permiso.id_permiso\n" + 
			"inner join ZonasDisponibles zona\n" + 
			"on permiso.id_zona = zona.id_zona\n" + 
			"inner join FotosPuesto fotopuesto\n" + 
			"on fotopuesto.id_puesto = puesto.id_puesto\n" + 
			"where zona.estado = 0 and permiso.estado = 1 and vendedor.id_vendedor = #{id_vendedor}")
	public List<UbicacionesInnerJoin> SelectUbicacionesInnerJoinPorIdVendedor(int id_vendedor);//categoria
	
	
	@Insert("insert into Zonasdisponibles(Apodo,longitud,latitud,estado) values(#{Apodo},#{longitud},#{latitud},#{estado})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_zona",keyProperty ="id_zona" )
	public void Register(Zonasdisponibles zonasdisponibles ); 
 
	@Update("update Zonasdisponibles set Apodo=#{Apodo},longitud=#{longitud},latitud=#{latitud},estado=#{estado} where id_zona= #{id_zona} ") 
	public void Update(Zonasdisponibles zonasdisponibles);
 
 }
