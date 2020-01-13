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
 
@Repository 
@Mapper 
public interface UbicacionesDAO {

	@Select("Select id_cliente,Apodo,longitud,latitud,direccion from Ubicaciones") 
	public List<Ubicaciones> SelectALL();
	@Select("Select * from Ubicaciones where Apodo = #{nombreubicacion} and id_cliente = #{id_cliente}")//Spubicaciones
	public Ubicaciones SelectByIdAndNombreUbicacion(int id_cliente,String nombreubicacion);
 
	@Select("Select id_cliente,Apodo,longitud,latitud,direccion from Ubicaciones where id_cliente= #{id_cliente} ") 
	public List<Ubicaciones> SelectById(Ubicaciones ubicaciones); 
 
	@Insert("insert into Ubicaciones(id_cliente,Apodo,longitud,latitud,direccion) values(#{id_cliente},#{Apodo},#{longitud},#{latitud},#{direccion})" ) 
	//@Options(useGeneratedKeys = true ,keyColumn = "id_cliente",keyProperty ="id_cliente" )
	public void Register(Ubicaciones ubicaciones ); 
 
	@Update("update Ubicaciones set Apodo=#{Apodo},longitud=#{longitud},latitud=#{latitud},direccion=#{direccion} where id_cliente= #{id_cliente} ") 
	public void Update(Ubicaciones ubicaciones);
 
 }
