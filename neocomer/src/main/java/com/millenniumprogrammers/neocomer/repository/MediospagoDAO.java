package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Mediospago; 
 
@Repository 
@Mapper 
public interface MediospagoDAO {

	@Select("Select id_cliente,NroTarjeta,CCV,FechaVenc from Mediospago") 
	public List<Mediospago> SelectALL(); 
 
	@Select("Select id_cliente,NroTarjeta,CCV,FechaVenc from Mediospago where id_cliente= #{id_cliente} ") 
	public Mediospago SelectById(Mediospago bean); 
 
	@Insert("insert into Mediospago(id_cliente,NroTarjeta,CCV,FechaVenc) values(#{id_cliente},#{NroTarjeta},#{CCV},#{FechaVenc})" ) 
	public int Register(Mediospago bean ); 
 
	@Update(" update Mediospago set id_cliente=#{id_cliente},NroTarjeta=#{NroTarjeta},CCV=#{CCV},FechaVenc=#{FechaVenc} where id_cliente=#{id_cliente} ") 
	public int Update(Mediospago bean);
 
 }
