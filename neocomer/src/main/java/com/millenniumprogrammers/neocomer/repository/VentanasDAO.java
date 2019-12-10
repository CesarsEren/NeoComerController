package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Ventanas; 
 
@Repository 
@Mapper 
public interface VentanasDAO {

	@Select("Select id_ventana,detalle from Ventanas") 
	public List<Ventanas> SelectALL(); 
 
	@Select("Select id_ventana,detalle from Ventanas where id_ventana= #{id_ventana} ") 
	public Ventanas SelectById(Ventanas ventanas); 
 
	@Insert("insert into Ventanas(detalle) values(#{detalle})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_ventana",keyProperty ="id_ventana" )
	public void Register(Ventanas ventanas ); 
 
	@Update("update Ventanas set detalle=#{detalle} where id_ventana= #{id_ventana} ") 
	public void Update(Ventanas ventanas);
 
 }
