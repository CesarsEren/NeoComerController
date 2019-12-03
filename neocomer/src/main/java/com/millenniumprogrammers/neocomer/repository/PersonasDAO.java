package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Personas; 
 
@Repository 
@Mapper 
public interface PersonasDAO {

	@Select("Select id_persona,DNI,Nombres,Apellidos,dirección,FechaNacimiento,FechaIngreso,Estado from Personas") 
	public List<Personas> SelectALL(); 
 
	@Select("Select id_persona,DNI,Nombres,Apellidos,dirección,FechaNacimiento,FechaIngreso,Estado from Personas where id_persona= #{id_persona} ") 
	public Personas SelectById(Personas bean); 
 
	@Insert("insert into Personas(DNI,Nombres,Apellidos,dirección,FechaNacimiento,FechaIngreso,Estado) values(#{DNI},#{Nombres},#{Apellidos},#{dirección},#{FechaNacimiento},#{FechaIngreso},#{Estado})" ) 
	public int Register(Personas bean ); 
 
	@Update("update Personas set Nombres=#{Nombres},Apellidos=#{Apellidos},dirección=#{dirección},FechaNacimiento=#{FechaNacimiento},FechaIngreso=#{FechaIngreso},Estado=#{Estado} where DNI=#{DNI} ") 
	public int Update(Personas bean);
 
 }
