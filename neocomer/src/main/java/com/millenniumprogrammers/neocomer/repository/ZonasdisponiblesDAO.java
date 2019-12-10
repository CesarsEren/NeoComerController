package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Zonasdisponibles; 
 
@Repository 
@Mapper 
public interface ZonasdisponiblesDAO {

	@Select("Select id_zona,Apodo,longitud,latitud,estado from Zonasdisponibles") 
	public List<Zonasdisponibles> SelectALL(); 
 
	@Select("Select id_zona,Apodo,longitud,latitud,estado from Zonasdisponibles where id_zona= #{id_zona} ") 
	public Zonasdisponibles SelectById(Zonasdisponibles zonasdisponibles); 
 
	@Insert("insert into Zonasdisponibles(Apodo,longitud,latitud,estado) values(#{Apodo},#{longitud},#{latitud},#{estado})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_zona",keyProperty ="id_zona" )
	public void Register(Zonasdisponibles zonasdisponibles ); 
 
	@Update("update Zonasdisponibles set Apodo=#{Apodo},longitud=#{longitud},latitud=#{latitud},estado=#{estado} where id_zona= #{id_zona} ") 
	public void Update(Zonasdisponibles zonasdisponibles);
 
 }
