package co.com.farmatech.metrofarm.dao.maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.com.farmatech.metrofarm.mapper.MaintenanceMapper;
import co.com.farmatech.metrofarm.properties.AccessMetroFarmProperties;
import co.jankins.psf.common.enums.TipoEquipo;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.global.GlobalUtils;

import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoMantenimiento;
import com.co.farmatech.metrofarm.dto.PageData;

public class MaintenanceDaoImpl implements MaintenanceDaoService{
	
	private Properties sqlProperties = AccessMetroFarmProperties.getInstance().getSQLProperties();
	private MaintenanceMapper mapper=new MaintenanceMapper();
	
	@Override
	public DtoMantenimiento createFirstMaintenance(
			DtoMantenimiento mantenimiento, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql="";
		if(mantenimiento.getEquipo().getTipo().equals(TipoEquipo.EQUIPO.getCode())){
			querySql=sqlProperties.getProperty("maintenanceEquipment.save");
		}else{
			querySql=sqlProperties.getProperty("maintenanceInstrument.save");
		}	
		try {
			p = con.prepareStatement(querySql);
			p.setString(1,mantenimiento.getEquipo().getCodigoInv());
			p.setLong(2,mantenimiento.getTipoMant());
			p.setString(3,mantenimiento.getResponsable());
			p.setString(4,mantenimiento.getRecibido());
			p.setString(5,mantenimiento.getRegistrado().getCodigo());
			p.setString(6,mantenimiento.getAnomalias());
			p.setString(7,mantenimiento.getLabores());
			p.setString(8,mantenimiento.getObservaciones());
			p.setString(9,mantenimiento.getProovedores());
			p.setTimestamp(10,new Timestamp(mantenimiento.getFechaRegistro().getTime()));
			p.setTimestamp(11,new Timestamp(mantenimiento.getFechaProximo().getTime()));
			p.setBigDecimal(12,mantenimiento.getPrecio());
			p.setDate(13,null);
			p.setLong(14,0);
			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				return mantenimiento;
			}else{
				throw new JankinsMarshallException("No se pudo crear el mantenimiento");
			}
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public boolean EquipmentMaintenance(DtoEquipo equipo, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql="";
		if(equipo.getTipo().equals(TipoEquipo.INSTRUMENTO.getCode())){
			querySql=sqlProperties.getProperty("equipment.maintenanceInstrument");
		}else{
			querySql=sqlProperties.getProperty("equipment.maintenanceEquipment");
		}	
		try {
			p = con.prepareStatement(querySql);
			p.setString(1,equipo.getCodigoInv());
			r= p.executeQuery();
			if(r.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public DtoMantenimiento createMaintenance(DtoMantenimiento mantenimiento,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql="";
		if(mantenimiento.getEquipo().getTipo().equals(TipoEquipo.EQUIPO.getCode())){
			querySql=sqlProperties.getProperty("maintenanceEquipment.save");
		}else{
			querySql=sqlProperties.getProperty("maintenanceInstrument.save");
		}	
		try {
			p = con.prepareStatement(querySql);
			p.setString(1,mantenimiento.getEquipo().getCodigoInv());
			p.setLong(2,mantenimiento.getTipoMant());
			p.setString(3,mantenimiento.getResponsable());
			p.setString(4,mantenimiento.getRecibido());
			p.setString(5,mantenimiento.getRegistrado().getCodigo());
			p.setString(6,mantenimiento.getAnomalias());
			p.setString(7,mantenimiento.getLabores());
			p.setString(8,mantenimiento.getObservaciones());
			p.setString(9,mantenimiento.getProovedores());
			p.setTimestamp(10,new Timestamp(mantenimiento.getFechaRegistro().getTime()));
			p.setTimestamp(11,new Timestamp(mantenimiento.getFechaProximo().getTime()));
			p.setBigDecimal(12,mantenimiento.getPrecio());
			p.setDate(13,null);
			p.setLong(14,0);
			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				updateScheduled(mantenimiento, con);
				return mantenimiento;
			}else{
				throw new JankinsMarshallException("No se pudo crear el mantenimiento");
			}
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public DtoMantenimiento updateMaintenance(DtoMantenimiento mantenimiento,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		String querySql="";
		if(mantenimiento.getEquipo().getTipo().equals(TipoEquipo.EQUIPO.getCode())){
			querySql=sqlProperties.getProperty("maintenanceEquipment.update");
		}else{
			querySql=sqlProperties.getProperty("maintenanceInstrument.update");
		}	
		try {
			p = con.prepareStatement(querySql);
			p.setLong(1,mantenimiento.getTipoMant());
			p.setString(2,mantenimiento.getResponsable());
			p.setString(3,mantenimiento.getRecibido());
			p.setString(4,mantenimiento.getRegistrado().getCodigo());
			p.setString(5,mantenimiento.getAnomalias());
			p.setString(6,mantenimiento.getLabores());
			p.setString(7,mantenimiento.getObservaciones());
			p.setString(8,mantenimiento.getProovedores());
			p.setBigDecimal(9,mantenimiento.getPrecio());
			p.setTimestamp(10,mantenimiento.getFechaEjecutado()!=null?new Timestamp(mantenimiento.getFechaEjecutado().getTime()):null);
			p.setLong(11,mantenimiento.getCumplio());
			p.setString(12,mantenimiento.getNumFom());
			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				return mantenimiento;
			}else{
				throw new JankinsMarshallException("No se pudo actualizar el mantenimiento");
			}
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateScheduled(DtoMantenimiento maintenance,Connection con){
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		PreparedStatement p = null;
		ResultSet r;
		String querySql="";
		if(maintenance.getEquipo().getTipo().equals(TipoEquipo.EQUIPO.getCode())){
			querySql=sqlProperties.getProperty("maintenanceEquipment.selectBefore");
		}else{
			querySql=sqlProperties.getProperty("maintenanceInstrument.selectBefore");
		}	
		try {
			p = datasource.getConexion().prepareStatement(querySql);	
			p.setString(1,maintenance.getEquipo().getCodigoInv());
			p.setTimestamp(2,new Timestamp(maintenance.getFechaRegistro().getTime()));
			r= p.executeQuery();
			ArrayList<DtoMantenimiento> maintenanceBefores=mapper.findMaintenance(r);
			if(maintenanceBefores!=null && !maintenanceBefores.isEmpty()){
				DtoMantenimiento maintenanceUpdate=maintenanceBefores.get(0);
				maintenanceUpdate.setFechaEjecutado(maintenance.getFechaRegistro());
				SimpleDateFormat formateador = new SimpleDateFormat("MM/yyyy");
				if(formateador.format(maintenanceUpdate.getFechaEjecutado()).equals(formateador.format(maintenanceUpdate.getFechaProximo()))){
					maintenanceUpdate.setCumplio(1);
				}else{
					maintenanceUpdate.setCumplio(0);
				}
				
				updateMaintenance(maintenanceUpdate, datasource.getConexion());
			}
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public DtoMantenimiento deleteMaintenance(DtoMantenimiento mantenimiento,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		String querySql="";

		if(mantenimiento.getEquipo().getTipo().equals(TipoEquipo.EQUIPO.getCode())){
			querySql=sqlProperties.getProperty("maintenanceEquipment.delete");
		}else{
			querySql=sqlProperties.getProperty("maintenanceInstrument.delete");
		}	
		try {
			p = con.prepareStatement(querySql);
			p.setString(1,mantenimiento.getNumFom());
			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				return mantenimiento;
			}else{
				throw new JankinsMarshallException("No se pudo eliminar el mantenimiento");
			}
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<DtoMantenimiento> findMaintenance(DtoMantenimiento mantenimiento, Connection con,PageData pageData) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql="";
		String q="";
		String alternativeQuery="";
		if(mantenimiento.getEquipo().getTipo().equals(TipoEquipo.EQUIPO.getCode())){
			querySql=sqlProperties.getProperty("maintenanceEquipment.select");
			q=sqlProperties.getProperty("maintenanceEquipment.selectCount");
		}else{
			querySql=sqlProperties.getProperty("maintenanceInstrument.select");
			q=sqlProperties.getProperty("maintenanceInstrument.selectCount");
		}	
		List<Object> params=new ArrayList<Object>();
		if(mantenimiento.getEquipo()!=null){
			if(mantenimiento.getEquipo().getCodigoInv()!=null){
				alternativeQuery+=" AND UPPER(E.codigoInventario)=UPPER(?)";
				params.add(mantenimiento.getEquipo().getCodigoInv());
			}
			if(mantenimiento.getEquipo().getCodigoMet()!=null){
				alternativeQuery+=" AND UPPER(E.codigoMetrologia)=UPPER(?)";
				params.add(mantenimiento.getEquipo().getCodigoMet());
			}
			if(mantenimiento.getEquipo().getSerie()!=null){
				alternativeQuery+=" AND UPPER(E.numeroSerie)=UPPER(?)";
				params.add(mantenimiento.getEquipo().getSerie());
			}
		}
		if(mantenimiento.getNumFom()!=null && !mantenimiento.getNumFom().isEmpty()){
			alternativeQuery+=" AND UPPER(M.idMantenimiento)=UPPER(?)";
			params.add(mantenimiento.getNumFom());
		}
		querySql+=alternativeQuery;
		q+=alternativeQuery;

		try {
			if(pageData!=null){
				querySql=GlobalUtils.getCountQuery(pageData, con,params,sqlProperties.getProperty("pagination.start"),sqlProperties.getProperty("pagination.end"),q,querySql);
			}
			Connection connection=DataSourceConnector.getInstance().getConexion();	
		
			p = connection.prepareStatement(querySql);
			for (int i = 0; i < params.size(); i++) {
				if(params.get(i) instanceof Integer){
					p.setInt(i+1,(Integer)params.get(i));
				}else{
					p.setString(i+1,(String)params.get(i));
				}
			}
			r= p.executeQuery();
			return mapper.findMaintenance(r);
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<DtoMantenimiento> findMaintenanceMonthScheduled(
			DtoMantenimiento mantenimiento, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql="";
		if(mantenimiento.getEquipo().getTipo().equals(TipoEquipo.EQUIPO.getCode())){
			querySql=sqlProperties.getProperty("maintenanceEquipment.select");
		}else{
			querySql=sqlProperties.getProperty("maintenanceInstrument.select");
		}	

		querySql+=" AND DATEDIFF(MONTH,DATEADD(MONTH, DATEDIFF(MONTH, 0, M.proximoMantenimiento), 0),GETDATE())=0 AND M.fechaEjecutada IS NULL";
		
		try {
			p = con.prepareStatement(querySql);
			r= p.executeQuery();
			return mapper.findMaintenance(r);
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<DtoMantenimiento> findMaintenanceMonthExpired(
			DtoMantenimiento mantenimiento, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql="";
		if(mantenimiento.getEquipo().getTipo().equals(TipoEquipo.EQUIPO.getCode())){
			querySql=sqlProperties.getProperty("maintenanceEquipment.select");
		}else{
			querySql=sqlProperties.getProperty("maintenanceInstrument.select");
		}	

		querySql+=" AND DATEDIFF(MONTH,DATEADD(MONTH, DATEDIFF(MONTH, 0, M.proximoMantenimiento), 0),GETDATE())>0 AND M.fechaEjecutada IS NULL";
		
		try {
			p = con.prepareStatement(querySql);
			r= p.executeQuery();
			return mapper.findMaintenance(r);
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
