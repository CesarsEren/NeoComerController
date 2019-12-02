package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Asociaciones; 
 
@Repository 
@Mapper 
public interface AsociacionesDAO {

	@Select("Select id_asociacion,id_rubro,RUC,Razon,Direccion,FechaRegistro, from Asociaciones") 
	public List<Asociaciones> SelectALL(); 
 
	@Select("Select id_asociacion,id_rubro,RUC,Razon,Direccion,FechaRegistro, from Asociaciones where id_asociacion= #{id_asociacion} ") 
	public Asociaciones SelectById(Asociaciones bean);
 
 }
