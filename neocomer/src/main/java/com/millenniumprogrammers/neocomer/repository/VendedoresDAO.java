package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Vendedores; 
 
@Repository 
@Mapper 
public interface VendedoresDAO {

	@Select("Select id_vendedor,id_persona,id_asociacion,id_permiso,correo,password,id_rol,estado, from Vendedores") 
	public List<Vendedores> SelectALL(); 
 
	@Select("Select id_vendedor,id_persona,id_asociacion,id_permiso,correo,password,id_rol,estado, from Vendedores where id_vendedor= #{id_vendedor} ") 
	public Vendedores SelectById(Vendedores bean);
 
 }
