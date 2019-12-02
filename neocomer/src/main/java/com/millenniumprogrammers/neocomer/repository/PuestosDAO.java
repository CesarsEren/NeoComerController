package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Puestos; 
 
@Repository 
@Mapper 
public interface PuestosDAO {

	@Select("Select id_puesto,Detalle,Color,Estado, from Puestos") 
	public List<Puestos> SelectALL(); 
 
	@Select("Select id_puesto,Detalle,Color,Estado, from Puestos where id_puesto= #{id_puesto} ") 
	public Puestos SelectById(Puestos bean);
 
 }
