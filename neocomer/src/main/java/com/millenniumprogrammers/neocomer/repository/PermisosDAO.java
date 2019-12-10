package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Permisos; 
 
@Repository 
@Mapper 
public interface PermisosDAO {

	@Select("Select id_permiso,id_trabajador,FechaRegistro,FechaFin,Estado,id_asociacion,id_zona from Permisos") 
	public List<Permisos> SelectALL(); 
 
	@Select("Select id_permiso,id_trabajador,FechaRegistro,FechaFin,Estado,id_asociacion,id_zona from Permisos where id_permiso= #{id_permiso} ") 
	public Permisos SelectById(Permisos permisos); 
 
	@Insert("insert into Permisos(id_trabajador,FechaRegistro,FechaFin,Estado,id_asociacion,id_zona) values(#{id_trabajador},#{FechaRegistro},#{FechaFin},#{Estado},#{id_asociacion},#{id_zona})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_permiso",keyProperty ="id_permiso" )
	public void Register(Permisos permisos ); 
 
	@Update("update Permisos set id_trabajador=#{id_trabajador},FechaRegistro=#{FechaRegistro},FechaFin=#{FechaFin},Estado=#{Estado},id_asociacion=#{id_asociacion},id_zona=#{id_zona} where id_permiso= #{id_permiso} ") 
	public void Update(Permisos permisos);
 
 }
