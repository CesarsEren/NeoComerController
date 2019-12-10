package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Asociaciones; 
 
@Repository 
@Mapper 
public interface AsociacionesDAO {

	@Select("Select id_asociacion,RUC,Razon,Direccion,FechaRegistro,estado from Asociaciones") 
	public List<Asociaciones> SelectALL(); 
 
	@Select("Select id_asociacion,RUC,Razon,Direccion,FechaRegistro,estado from Asociaciones where id_asociacion= #{id_asociacion} ") 
	public Asociaciones SelectById(Asociaciones asociaciones); 
 
	@Insert("insert into Asociaciones(RUC,Razon,Direccion,FechaRegistro,estado) values(#{RUC},#{Razon},#{Direccion},#{FechaRegistro},#{estado})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_asociacion",keyProperty ="id_asociacion" )
	public void Register(Asociaciones asociaciones ); 
 
	@Update("update Asociaciones set RUC=#{RUC},Razon=#{Razon},Direccion=#{Direccion},FechaRegistro=#{FechaRegistro},estado=#{estado} where id_asociacion= #{id_asociacion} ") 
	public void Update(Asociaciones asociaciones);
 
 }
