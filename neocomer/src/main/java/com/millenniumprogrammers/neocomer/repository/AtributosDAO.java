package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Atributos; 
 
@Repository 
@Mapper 
public interface AtributosDAO {

	@Select("Select id_atributo,detalle from Atributos") 
	public List<Atributos> SelectALL(); 
 
	@Select("Select id_atributo,detalle from Atributos where id_atributo= #{id_atributo} ") 
	public Atributos SelectById(Atributos atributos); 
 
	@Insert("insert into Atributos(detalle) values(#{detalle})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_atributo",keyProperty ="id_atributo" )
	public void Register(Atributos atributos ); 
 
	@Update("update Atributos set detalle=#{detalle} where id_atributo= #{id_atributo} ") 
	public void Update(Atributos atributos);
 
 }
