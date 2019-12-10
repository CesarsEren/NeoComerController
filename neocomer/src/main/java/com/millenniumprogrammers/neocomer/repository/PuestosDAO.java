package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Puestos; 
 
@Repository 
@Mapper 
public interface PuestosDAO {

	@Select("Select id_puesto,Detalle,Color,Estado,Referencia from Puestos") 
	public List<Puestos> SelectALL(); 
 
	@Select("Select id_puesto,Detalle,Color,Estado,Referencia from Puestos where id_puesto= #{id_puesto} ") 
	public Puestos SelectById(Puestos puestos); 
 
	@Insert("insert into Puestos(Detalle,Color,Estado,Referencia) values(#{Detalle},#{Color},#{Estado},#{Referencia})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_puesto",keyProperty ="id_puesto" )
	public void Register(Puestos puestos ); 
 
	@Update("update Puestos set Detalle=#{Detalle},Color=#{Color},Estado=#{Estado},Referencia=#{Referencia} where id_puesto= #{id_puesto} ") 
	public void Update(Puestos puestos);
 
 }
