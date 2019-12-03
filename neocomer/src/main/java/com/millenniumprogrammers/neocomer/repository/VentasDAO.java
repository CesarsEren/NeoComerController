package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import com.millenniumprogrammers.neocomer.model.Ventas; 
 
@Repository 
@Mapper 
public interface VentasDAO {

	@Select("Select id_venta,id_cliente,id_vendedor,DNI,NombreCompleto,PrecioProd,cantidad,Tipo,Serie,Numero from Ventas") 
	public List<Ventas> SelectALL(); 
 
	@Select("Select id_venta,id_cliente,id_vendedor,DNI,NombreCompleto,PrecioProd,cantidad,Tipo,Serie,Numero from Ventas where id_venta= #{id_venta} ") 
	public Ventas SelectById(Ventas bean); 
 
	@Insert("insert into Ventas(id_cliente,id_vendedor,DNI,NombreCompleto,PrecioProd,cantidad,Tipo,Serie,Numero) values(#{id_cliente},#{id_vendedor},#{DNI},#{NombreCompleto},#{PrecioProd},#{cantidad},#{Tipo},#{Serie},#{Numero})" ) 
	public int Register(Ventas bean ); 
 
	@Update("update Ventas set id_vendedor=#{id_vendedor},DNI=#{DNI},NombreCompleto=#{NombreCompleto},PrecioProd=#{PrecioProd},cantidad=#{cantidad},Tipo=#{Tipo},Serie=#{Serie},Numero=#{Numero} where id_cliente=#{id_cliente} ") 
	public int Update(Ventas bean);
 
 }
