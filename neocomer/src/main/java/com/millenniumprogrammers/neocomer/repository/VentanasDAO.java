package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Ventanas; 
 
@Repository 
@Mapper 
public interface VentanasDAO {

	@Select("Select id_ventana,detalle, from Ventanas") 
	public List<Ventanas> SelectALL(); 
 
	@Select("Select id_ventana,detalle, from Ventanas where id_ventana= #{id_ventana} ") 
	public Ventanas SelectById(Ventanas bean);
 
 }
