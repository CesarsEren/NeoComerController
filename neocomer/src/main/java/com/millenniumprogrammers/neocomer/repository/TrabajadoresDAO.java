package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Trabajadores; 
 
@Repository 
@Mapper 
public interface TrabajadoresDAO {

	@Select("Select id_trabajador,id_persona,correo,password,estado,id_rol from Trabajadores") 
	public List<Trabajadores> SelectALL(); 
 
	@Select("Select id_trabajador,id_persona,correo,password,estado,id_rol from Trabajadores where id_trabajador= #{id_trabajador} ") 
	public Trabajadores SelectById(Trabajadores trabajadores); 
	
	@Select("select * from Trabajadores where correo = #{correo} and password = #{password} and estado = 1")
	public Trabajadores SelectByCorreoAndPassword(String correo,String password);
 
	@Insert("insert into Trabajadores(id_persona,correo,password,estado,id_rol) values(#{id_persona},#{correo},#{password},#{estado},#{id_rol})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_trabajador",keyProperty ="id_trabajador" )
	public void Register(Trabajadores trabajadores ); 
 
	@Update("update Trabajadores set id_persona=#{id_persona},correo=#{correo},password=#{password},estado=#{estado},id_rol=#{id_rol} where id_trabajador= #{id_trabajador} ") 
	public void Update(Trabajadores trabajadores);
 
 }
