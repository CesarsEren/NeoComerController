package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Fotospuesto; 
 
@Repository 
@Mapper 
public interface FotospuestoDAO {

	@Select("Select id_foto,foto,estado, from Fotospuesto") 
	public List<Fotospuesto> SelectALL(); 
 
	@Select("Select id_foto,foto,estado, from Fotospuesto where id_foto= #{id_foto} ") 
	public Fotospuesto SelectById(Fotospuesto bean);
 
 }
