package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Fotospuesto; 
 
@Repository 
@Mapper 
public interface FotospuestoDAO {

	@Select("Select id_foto,foto,estado,id_puesto from Fotospuesto") 
	public List<Fotospuesto> SelectALL(); 
 
	@Select("Select id_foto,foto,estado,id_puesto from Fotospuesto where id_foto= #{id_foto} ") 
	public Fotospuesto SelectById(Fotospuesto fotospuesto); 
 
	@Insert("insert into Fotospuesto(foto,estado,id_puesto) values(#{foto},#{estado},#{id_puesto})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_foto",keyProperty ="id_foto" )
	public void Register(Fotospuesto fotospuesto ); 
 
	@Update("update Fotospuesto set foto=#{foto},estado=#{estado},id_puesto=#{id_puesto} where id_foto= #{id_foto} ") 
	public void Update(Fotospuesto fotospuesto);
 
 }
