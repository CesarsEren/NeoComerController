package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Roles; 
 
@Repository 
@Mapper 
public interface RolesDAO {

	@Select("Select id_rol,detalle from Roles") 
	public List<Roles> SelectALL(); 
 
	@Select("Select id_rol,detalle from Roles where id_rol= #{id_rol} ") 
	public Roles SelectById(Roles roles); 
 
	@Insert("insert into Roles(detalle) values(#{detalle})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_rol",keyProperty ="id_rol" )
	public void Register(Roles roles ); 
 
	@Update("update Roles set detalle=#{detalle} where id_rol= #{id_rol} ") 
	public void Update(Roles roles);
 
 }
