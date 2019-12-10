package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Vendedores; 
 
@Repository 
@Mapper 
public interface VendedoresDAO {

	@Select("Select id_vendedor,id_persona,id_asociacion,id_permiso,correo,password,estado,id_puesto from Vendedores") 
	public List<Vendedores> SelectALL(); 
 
	@Select("Select id_vendedor,id_persona,id_asociacion,id_permiso,correo,password,estado,id_puesto from Vendedores where id_vendedor= #{id_vendedor} ") 
	public Vendedores SelectById(Vendedores vendedores); 
 
	@Select("select * from Vendedores where correo = #{correo} and password = #{password} and estado = 1")
	public Vendedores SelectByCorreoAndPassword(String correo,String password); 
	
	@Insert("insert into Vendedores(id_persona,id_asociacion,id_permiso,correo,password,estado,id_puesto) values(#{id_persona},#{id_asociacion},#{id_permiso},#{correo},#{password},#{estado},#{id_puesto})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_vendedor",keyProperty ="id_vendedor" )
	public void Register(Vendedores vendedores ); 
 
	@Update("update Vendedores set id_persona=#{id_persona},id_asociacion=#{id_asociacion},id_permiso=#{id_permiso},correo=#{correo},password=#{password},estado=#{estado},id_puesto=#{id_puesto} where id_vendedor= #{id_vendedor} ") 
	public void Update(Vendedores vendedores);
 
 }
