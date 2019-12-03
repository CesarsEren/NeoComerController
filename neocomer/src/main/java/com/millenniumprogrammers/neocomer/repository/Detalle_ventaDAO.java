package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Detalle_venta; 
 
@Repository 
@Mapper 
public interface Detalle_ventaDAO {

	@Select("Select id_venta,id_producto from Detalle_venta") 
	public List<Detalle_venta> SelectALL(); 
 
	@Select("Select id_venta,id_producto from Detalle_venta where id_venta= #{id_venta} ") 
	public Detalle_venta SelectById(Detalle_venta bean); 
 
	@Insert("insert into Detalle_venta(id_venta,id_producto) values(#{id_venta},#{id_producto})" ) 
	public int Register(Detalle_venta bean ); 
 
	@Update(" update Detalle_venta set id_venta=#{id_venta},id_producto=#{id_producto} where id_venta=#{id_venta} ") 
	public int Update(Detalle_venta bean);
 
 }
