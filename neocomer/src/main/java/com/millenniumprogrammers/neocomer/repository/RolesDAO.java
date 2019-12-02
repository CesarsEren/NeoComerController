package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Roles; 
 
@Repository 
@Mapper 
public interface RolesDAO {

	@Select("Select id_rol,detalle, from Roles") 
	public List<Roles> SelectALL(); 
 
	@Select("Select id_rol,detalle, from Roles where id_rol= #{id_rol} ") 
	public Roles SelectById(Roles bean);
 
 }
