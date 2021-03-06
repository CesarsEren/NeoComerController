package com.millenniumprogrammers.neocomer.repository;
 
import java.util.List; 
import org.apache.ibatis.annotations.Delete; 
import org.apache.ibatis.annotations.Insert; 
import org.apache.ibatis.annotations.Mapper; 
import org.apache.ibatis.annotations.Select; 
import org.apache.ibatis.annotations.Update; 
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Options;
import com.millenniumprogrammers.neocomer.model.Reclamos; 
 
@Repository 
@Mapper 
public interface ReclamosDAO {

	@Select("Select id_reclamo,id_cliente,id_vendedor,id_venta,detalle_solucion,detalle_reclamo,FechaReg,FechaVenc,solucionado from Reclamos") 
	public List<Reclamos> SelectALL(); 
 
	@Select("Select id_reclamo,id_cliente,id_vendedor,id_venta,detalle_solucion,detalle_reclamo,FechaReg,FechaVenc,solucionado from Reclamos where id_reclamo= #{id_reclamo} ") 
	public Reclamos SelectById(Reclamos reclamos); 
 
	@Insert("insert into Reclamos(id_cliente,id_vendedor,id_venta,detalle_solucion,detalle_reclamo,FechaReg,FechaVenc,solucionado) values(#{id_cliente},#{id_vendedor},#{id_venta},#{detalle_solucion},#{detalle_reclamo},#{FechaReg},#{FechaVenc},#{solucionado})" ) 
	@Options(useGeneratedKeys = true ,keyColumn = "id_reclamo",keyProperty ="id_reclamo" )
	public void Register(Reclamos reclamos ); 
 
	@Update("update Reclamos set id_cliente=#{id_cliente},id_vendedor=#{id_vendedor},id_venta=#{id_venta},detalle_solucion=#{detalle_solucion},detalle_reclamo=#{detalle_reclamo},FechaReg=#{FechaReg},FechaVenc=#{FechaVenc},solucionado=#{solucionado} where id_reclamo= #{id_reclamo} ") 
	public void Update(Reclamos reclamos);
 
 }
