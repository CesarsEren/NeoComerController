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

	@Select("Select id_cliente,NroTarjeta,CCV,FechaVenc from Mediospago") 
	public List<Mediospago> SelectALL(); 
 
	@Select("Select id_cliente,NroTarjeta,CCV,FechaVenc from Mediospago where id_cliente= #{id_cliente} ") 
	public Mediospago SelectById(Mediospago mediospago); 
 
	@Insert("insert into Mediospago(NroTarjeta,CCV,FechaVenc) values(#{NroTarjeta},#{CCV},#{FechaVenc})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_cliente",keyProperty ="id_cliente" )
	public void Register(Mediospago mediospago ); 
 
	@Update("update Mediospago set NroTarjeta=#{NroTarjeta},CCV=#{CCV},FechaVenc=#{FechaVenc} where id_cliente= #{id_cliente} ") 
	public void Update(Mediospago mediospago);
 
 }
