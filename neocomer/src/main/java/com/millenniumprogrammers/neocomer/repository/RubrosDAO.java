package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Rubros; 
 
@Repository 
@Mapper 
public interface RubrosDAO {

	@Select("Select id_rubro,detalle from Rubros") 
	public List<Rubros> SelectALL(); 
 
	@Select("Select id_rubro,detalle from Rubros where id_rubro= #{id_rubro} ") 
	public Rubros SelectById(Rubros bean); 
 
	@Insert("insert into Rubros(id_rubro,detalle) values(#{id_rubro},#{detalle})" ) 
	public int Register(Rubros bean ); 
 
	@Update(" update Rubros set id_rubro=#{id_rubro},detalle=#{detalle} where id_rubro=#{id_rubro} ") 
	public int Update(Rubros bean);
 
 }