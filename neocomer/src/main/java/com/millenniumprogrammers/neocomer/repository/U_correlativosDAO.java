package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.U_correlativos; 
 
@Repository 
@Mapper 
public interface U_correlativosDAO {

	@Select("Select id_correlativo,id_vendedor,serie,numero from U_correlativos") 
	public List<U_correlativos> SelectALL(); 
 
	@Select("Select id_correlativo,id_vendedor,serie,numero from U_correlativos where id_correlativo= #{id_correlativo} ") 
	public U_correlativos SelectById(U_correlativos bean); 
 
	@Insert("insert into U_correlativos(id_correlativo,id_vendedor,serie,numero) values(#{id_correlativo},#{id_vendedor},#{serie},#{numero})" ) 
	public int Register(U_correlativos bean ); 
 
	@Update(" update U_correlativos set id_correlativo=#{id_correlativo},id_vendedor=#{id_vendedor},serie=#{serie},numero=#{numero} where id_correlativo=#{id_correlativo} ") 
	public int Update(U_correlativos bean);
 
 }
