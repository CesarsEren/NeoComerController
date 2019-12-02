package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Productos; 
 
@Repository 
@Mapper 
public interface ProductosDAO {

	@Select("Select id_producto,idvendedor,nombreproducto,precio, from Productos") 
	public List<Productos> SelectALL(); 
 
	@Select("Select id_producto,idvendedor,nombreproducto,precio, from Productos where id_producto= #{id_producto} ") 
	public Productos SelectById(Productos bean);
 
 }
