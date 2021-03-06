package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Clientes; 
 
@Repository 
@Mapper 
public interface ClientesDAO {

	@Select("Select id_cliente,id_persona,correo,password from Clientes") 
	public List<Clientes> SelectALL(); 
 
	@Select("Select id_cliente,id_persona,correo,password from Clientes where id_cliente= #{id_cliente} ") 
	public Clientes SelectById(Clientes clientes); 
 
	@Select("select * from Clientes where correo = #{correo} and password = #{password}")
	public Clientes SelectByCorreoAndPassword(String correo,String password); 
	
	@Insert("insert into Clientes(id_persona,correo,password) values(#{id_persona},#{correo},#{password})" ) 
	@Options(useGeneratedKeys = true,keyColumn = "id_cliente",keyProperty ="id_cliente" )
	public void Register(Clientes clientes ); 
 
	@Update("update Clientes set correo=#{correo},password=#{password} where id_cliente= #{id_cliente} ") 
	public void Update(Clientes clientes);
	
	@Update("update Clientes set foto = #{foto} where id_cliente= #{id_cliente} ") 
	public void UpdateFoto(Clientes clientes);
	
 }
