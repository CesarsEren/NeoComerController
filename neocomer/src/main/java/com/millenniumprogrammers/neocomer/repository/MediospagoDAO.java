package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Mediospago; 
 
@Repository 
@Mapper 
public interface MediospagoDAO {

	/*@Select("Select id_cliente,NroTarjeta,CCV,FechaVenc from Mediospago") 
	public List<Mediospago> SelectALL(); */
 
	@Select("Select id_cliente,id_mediopago,Nombre,Apellido,NroTarjeta,CCV,FechaVenc from Mediospago where id_cliente= #{id_cliente} ") 
	public List<Mediospago> SelectById(Mediospago mediospago); 
 
	@Insert("insert into Mediospago(id_cliente,Nombre,Apellido,NroTarjeta,CCV,FechaVenc) values(#{id_cliente},#{Nombre},#{Apellido},#{NroTarjeta},#{CCV},#{FechaVenc})" ) 
	//@Options(useGeneratedKeys = true ,keyColumn = "id_cliente",keyProperty ="id_cliente" )
	public void Register(Mediospago mediospago ); 
 
	@Update("update Mediospago set NroTarjeta=#{NroTarjeta},CCV=#{CCV},FechaVenc=#{FechaVenc} where id_cliente= #{id_cliente} ") 
	public void Update(Mediospago mediospago);
	
	@Delete("Delete Mediospago where id_cliente = #{id_cliente} and id_mediopago = #{id_mediopago}")
	public int Delete(Mediospago mediospago);
 
 }
