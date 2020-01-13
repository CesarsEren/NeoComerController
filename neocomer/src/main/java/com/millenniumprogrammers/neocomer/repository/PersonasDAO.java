package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Personas; 
 
@Repository 
@Mapper 
public interface PersonasDAO {

	@Select("Select id_persona,DNI,Nombres,Apellidos,FechaNacimiento,FechaIngreso,Estado,Direccion from Personas") 
	public List<Personas> SelectALL(); 
 
	@Select("Select id_persona,DNI,Nombres,Apellidos,FechaNacimiento,FechaIngreso,Estado,Direccion from Personas where id_persona= #{id_persona} ") 
	public Personas SelectById(Personas personas); 
 
	@Insert("insert into Personas(DNI,Nombres,Apellidos,FechaNacimiento,FechaIngreso,Estado,Direccion) values(#{DNI},#{Nombres},#{Apellidos},#{FechaNacimiento},#{FechaIngreso},#{Estado},#{Direccion})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_persona",keyProperty ="id_persona" )
	public void Register(Personas personas ); 
 
	@Update("update Personas set Nombres=#{Nombres},Apellidos=#{Apellidos},FechaNacimiento=#{FechaNacimiento} where id_persona= #{id_persona}") 
	public void Update(Personas personas);
 
 }
