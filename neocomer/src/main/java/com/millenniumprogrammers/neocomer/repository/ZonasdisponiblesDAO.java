package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Zonasdisponibles; 
 
@Repository 
@Mapper 
public interface ZonasdisponiblesDAO {

	@Select("Select id_zona,Apodo,longitud,latitud,estado from Zonasdisponibles") 
	public List<Zonasdisponibles> SelectALL(); 
 
	@Select("Select id_zona,Apodo,longitud,latitud,estado from Zonasdisponibles where id_zona= #{id_zona} ") 
	public Zonasdisponibles SelectById(Zonasdisponibles bean); 
 
	@Insert("insert into Zonasdisponibles(id_zona,Apodo,longitud,latitud,estado) values(#{id_zona},#{Apodo},#{longitud},#{latitud},#{estado})" ) 
	public int Register(Zonasdisponibles bean ); 
 
	@Update(" update Zonasdisponibles set id_zona=#{id_zona},Apodo=#{Apodo},longitud=#{longitud},latitud=#{latitud},estado=#{estado} where id_zona=#{id_zona} ") 
	public int Update(Zonasdisponibles bean);
 
 }