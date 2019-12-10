package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Productos; 
 
@Repository 
@Mapper 
public interface ProductosDAO {

	@Select("Select id_producto,idvendedor,nombreproducto,precio from Productos") 
	public List<Productos> SelectALL(); 
 
	@Select("Select id_producto,idvendedor,nombreproducto,precio from Productos where id_producto= #{id_producto} ") 
	public Productos SelectById(Productos productos); 
 
	@Insert("insert into Productos(idvendedor,nombreproducto,precio) values(#{idvendedor},#{nombreproducto},#{precio})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_producto",keyProperty ="id_producto" )
	public void Register(Productos productos ); 
 
	@Update("update Productos set idvendedor=#{idvendedor},nombreproducto=#{nombreproducto},precio=#{precio} where id_producto= #{id_producto} ") 
	public void Update(Productos productos);
 
 }
