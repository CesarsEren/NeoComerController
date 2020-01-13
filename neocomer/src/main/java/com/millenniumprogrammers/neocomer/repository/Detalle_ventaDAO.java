package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Detalle_venta; 
 
@Repository 
@Mapper 
public interface Detalle_ventaDAO {

	@Select("Select id_venta,id_producto from Detalle_venta") 
	public List<Detalle_venta> SelectALL(); 
 
	@Select("Select id_venta,id_producto from Detalle_venta where id_venta= #{id_venta} ") 
	public Detalle_venta SelectById(Detalle_venta detalle_venta);
	
	@Select("Select * from Detalle_venta where id_venta= #{id_venta} ") 
	public List<Detalle_venta> SelectDetalletById(int id_venta); 
 
	@Insert("insert into Detalle_venta(id_venta,id_producto,nombreproducto,precioproducto,fotoproducto,cantidad) "
			+ "values(#{id_venta},#{id_producto},#{nombreproducto},#{precioproducto},#{fotoproducto},#{cantidad})" ) 
	//@Options(useGeneratedKeys = true ,keyColumn = "id_venta",keyProperty ="id_venta" )
	public void Register(Detalle_venta detalle_venta); 
 
	@Update("update Detalle_venta set id_producto=#{id_producto} where id_venta= #{id_venta} ") 
	public void Update(Detalle_venta detalle_venta);
   
 }
