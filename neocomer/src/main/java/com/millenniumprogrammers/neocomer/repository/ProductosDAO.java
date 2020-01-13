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

	@Select("Select id_producto,idvendedor,categoriaproducto,nombreproducto,precio from Productos") 
	public List<Productos> SelectALL(); 
 
	@Select("Select id_producto,idvendedor,categoriaproducto,nombreproducto,precio,foto from Productos where idvendedor= #{idvendedor} ") 
	public List<Productos> SelectByIdVendedor(Productos productos);//SelectByPuesto
	
	@Select("Select id_producto,idvendedor,categoriaproducto,nombreproducto,precio,foto from Productos where idvendedor= #{idvendedor} and categoriaproducto = #{categoriaproducto} ") 
	public List<Productos> SelectByIdVendedorAndCategoria(Productos productos);//SelectByPuesto
	
	@Insert("insert into Productos(idvendedor,nombreproducto,categoriaproducto,precio,foto) values(#{idvendedor},#{nombreproducto},#{categoriaproducto},#{precio},#{foto})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_producto",keyProperty ="id_producto" )
	public void Register(Productos productos ); 
	
	@Insert("insert into Productos(idvendedor,nombreproducto,categoriaproducto,precio,foto) values(#{idvendedor},#{nombreproducto},#{categoriaproducto},#{precio},#{foto})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_producto",keyProperty ="id_producto" )
	public Productos Register2(Productos productos );
 
	@Update("update Productos set nombreproducto= #{nombreproducto},precio= #{precio} ,categoriaproducto = #{categoriaproducto} ,foto = #{foto} where id_producto= #{id_producto}") 
	public void Update(Productos productos);
 
 }
