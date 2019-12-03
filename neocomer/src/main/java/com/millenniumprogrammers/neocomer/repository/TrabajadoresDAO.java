package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Trabajadores; 
 
@Repository 
@Mapper 
public interface TrabajadoresDAO {

	@Select("Select id_trabajador,id_persona,correo,password,estado,id_rol from Trabajadores") 
	public List<Trabajadores> SelectALL(); 
 
	@Select("Select id_trabajador,id_persona,correo,password,estado,id_rol from Trabajadores where id_trabajador= #{id_trabajador} ") 
	public Trabajadores SelectById(Trabajadores bean); 
 
	@Insert("insert into Trabajadores(id_trabajador,id_persona,correo,password,estado,id_rol) values(#{id_trabajador},#{id_persona},#{correo},#{password},#{estado},#{id_rol})" ) 
	public int Register(Trabajadores bean ); 
 
	@Update(" update Trabajadores set id_trabajador=#{id_trabajador},id_persona=#{id_persona},correo=#{correo},password=#{password},estado=#{estado},id_rol=#{id_rol} where id_trabajador=#{id_trabajador} ") 
	public int Update(Trabajadores bean);
 
 }
