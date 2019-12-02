package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Clientes; 
 
@Repository 
@Mapper 
public interface ClientesDAO {

	@Select("Select id_cliente,id_persona,correo,password, from Clientes") 
	public List<Clientes> SelectALL(); 
 
	@Select("Select id_cliente,id_persona,correo,password, from Clientes where id_cliente= #{id_cliente} ") 
	public Clientes SelectById(Clientes bean);
 
 }
