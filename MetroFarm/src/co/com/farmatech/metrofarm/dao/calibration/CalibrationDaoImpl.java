package co.com.farmatech.metrofarm.dao.calibration;

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
import co.com.farmatech.metrofarm.mapper.CalibrationMapper;
import co.com.farmatech.metrofarm.mapper.ProviderMapper;
import co.com.farmatech.metrofarm.properties.AccessMetroFarmProperties;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.global.GlobalUtils;

import com.co.farmatech.metrofarm.dto.DtoCalibracion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProveedor;
import com.co.farmatech.metrofarm.dto.PageData;

public class CalibrationDaoImpl implements CalibrationDaoService{
	
	CalibrationMapper mapper=new CalibrationMapper();
	ProviderMapper mapperProvider=new ProviderMapper();

	
	
	
	//con el patron
	private Properties sqlProperties = AccessMetroFarmProperties.getInstance().getSQLProperties();
	
	//Sin el patron
	AccessMetroFarmProperties sqlPropertiesSinPatron=new AccessMetroFarmProperties();
	Properties prop= sqlPropertiesSinPatron.getSQLProperties();
	
	
	
	
	
	
	
	
	@Override
	public DtoCalibracion createFirstCalibration(DtoCalibracion calibration,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("calibration.save");
		try {
			p = con.prepareStatement(querySql);
			p.setString(1,calibration.getEquipo().getCodigoInv());
			p.setString(2,calibration.getDivision());
			p.setString(3,calibration.getExactitud());
			p.setString(4,calibration.getValMaximo());
			p.setString(5,calibration.getValMininmo());
			p.setString(6,calibration.getRangCalibracion());
			p.setString(7,calibration.getRangTrabajo());
			p.setString(8,calibration.getProveedor());
			p.setTimestamp(9,new Timestamp(calibration.getFechaRegistro().getTime()));
			p.setTimestamp(10,new Timestamp(calibration.getProximaCalibracion().getTime()));
			p.setBytes(11,calibration.getArchivo());
			p.setBigDecimal(12,calibration.getPrecio());
			p.setLong(13,0);
			p.setDate(14,null);
			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				return calibration;
			}else{
				throw new JankinsMarshallException("No se pudo crear la calibracion");
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
	public boolean EquipmentCalibration(DtoEquipo equipo, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("equipment.calibration");
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
	public ArrayList<DtoCalibracion> findCalibration(DtoEquipo equipo, Connection con,PageData pageData) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql=sqlProperties.getProperty("calibration.select");
		String q=sqlProperties.getProperty("calibration.selectCount");
		String alternativeQuery="";
		if(equipo.getCodigoInv()!=null){
			alternativeQuery+=" AND UPPER(E.codigoInventario)=UPPER(?)";
			params.add(equipo.getCodigoInv());
		}
		if(equipo.getCodigoMet()!=null){
			alternativeQuery+=" AND UPPER(E.codigoMetrologia)=UPPER(?)";
			params.add(equipo.getCodigoMet());
		}
		if(equipo.getSerie()!=null){
			alternativeQuery+=" AND UPPER(E.numeroSerie)=UPPER(?)";
			params.add(equipo.getSerie());
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
			return mapper.findCalibrations(r);
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
	public ArrayList<DtoCalibracion> findCalibration(DtoCalibracion calibration, Connection con,PageData pageData) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql=sqlProperties.getProperty("calibration.select");
		String q=sqlProperties.getProperty("calibration.selectCount");
		String alternativeQuery="";
		if(calibration.getCodigoCalibracion()!=null){
			alternativeQuery+=" AND UPPER(C.codigoCalibracion)=UPPER(?)";
			params.add(calibration.getCodigoCalibracion());
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
			return mapper.findCalibrations(r);
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
	public DtoCalibracion createCalibration(DtoCalibracion calibration,
			Connection con) {
		// TODO Auto-generated method stub
		
		updateScheduled(calibration,con);
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("calibration.save");
		try {
			p = datasource.getConexion().prepareStatement(querySql);
			p.setString(1,calibration.getEquipo().getCodigoInv());
			p.setString(2,calibration.getDivision());
			p.setString(3,calibration.getExactitud());
			p.setString(4,calibration.getValMaximo());
			p.setString(5,calibration.getValMininmo());
			p.setString(6,calibration.getRangCalibracion());
			p.setString(7,calibration.getRangTrabajo());
			p.setString(8,calibration.getProveedor());
			p.setTimestamp(9,new Timestamp(calibration.getFechaRegistro().getTime()));
			p.setTimestamp(10,new Timestamp(calibration.getProximaCalibracion().getTime()));
			p.setBytes(11,calibration.getArchivo());
			p.setBigDecimal(12,calibration.getPrecio());
			p.setLong(13,0);
			p.setDate(14,null);
			p.executeUpdate();
					
			return calibration;

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
	
	public void updateScheduled(DtoCalibracion calibrationRegister,Connection con){
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("calibration.selectBefore");
		try {
			p = datasource.getConexion().prepareStatement(querySql);	
			p.setString(1,calibrationRegister.getEquipo().getCodigoInv());
			p.setTimestamp(2,new Timestamp(calibrationRegister.getFechaRegistro().getTime()));
			r= p.executeQuery();
			ArrayList<DtoCalibracion> calibrationBefores=mapper.findCalibrations(r);
			if(calibrationBefores!=null && !calibrationBefores.isEmpty()){
				DtoCalibracion calibrationUpdate=calibrationBefores.get(0);
				calibrationUpdate.setFechaEjecutada(calibrationRegister.getFechaRegistro());
				SimpleDateFormat formateador = new SimpleDateFormat("MM/yyyy");
				if(formateador.format(calibrationUpdate.getFechaEjecutada()).equals(formateador.format(calibrationUpdate.getProximaCalibracion()))){
					calibrationUpdate.setCumplio(1);
				}else{
					calibrationUpdate.setCumplio(0);
				}
				updateCalibration(calibrationUpdate, datasource.getConexion());
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
	
	public void updateScheduledDelete(DtoCalibracion calibrationRegister,Connection con){
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("calibration.selectBefore");
		try {
			p = con.prepareStatement(querySql);	
			p.setString(1,calibrationRegister.getEquipo().getCodigoInv());
			p.setTimestamp(2,new Timestamp(calibrationRegister.getFechaRegistro().getTime()));
			r= p.executeQuery();
			ArrayList<DtoCalibracion> calibrationBefores=mapper.findCalibrations(r);
			if(calibrationBefores!=null && !calibrationBefores.isEmpty()){
				DtoCalibracion calibrationUpdate=calibrationBefores.get(0);
				calibrationUpdate.setFechaEjecutada(null);
				calibrationUpdate.setCumplio(0);

				DataSourceConnector datasource = DataSourceConnector.getInstance();
				updateCalibration(calibrationUpdate, datasource.getConexion());
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
	public DtoCalibracion updateCalibration(DtoCalibracion calibration,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		String querySql=sqlProperties.getProperty("calibration.update");
		try {
			p = con.prepareStatement(querySql);
			p.setString(1,calibration.getDivision());
			p.setString(2,calibration.getExactitud());
			p.setString(3,calibration.getValMaximo());
			p.setString(4,calibration.getValMininmo());
			p.setString(5,calibration.getRangCalibracion());
			p.setString(6,calibration.getRangTrabajo());
			p.setString(7,calibration.getProveedor());
			p.setBytes(8,calibration.getArchivo());
			p.setBigDecimal(9,calibration.getPrecio());
			p.setLong(10,calibration.getCumplio());
			p.setTimestamp(11,calibration.getFechaEjecutada()!=null?new Timestamp(calibration.getFechaEjecutada().getTime()):null);
			p.setString(12,calibration.getCodigoCalibracion());
			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				return calibration;
			}else{
				throw new JankinsMarshallException("No se pudo actualizar la calibracion");
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
	public ArrayList<DtoCalibracion> findCalibrationMonthScheduled(
			DtoEquipo equipo, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql=sqlProperties.getProperty("calibration.select");

		querySql+=" AND DATEDIFF(MONTH,DATEADD(MONTH, DATEDIFF(MONTH, 0, C.ProximaCalibracion), 0),GETDATE())=0 AND C.fechaEjecutada is null";
		
		try {
			p = con.prepareStatement(querySql);
			r= p.executeQuery();
			return mapper.findCalibrations(r);
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
	public ArrayList<DtoCalibracion> findCalibrationMonthExpired(
			DtoEquipo equipo, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql=sqlProperties.getProperty("calibration.select");
		
		querySql+=" AND DATEDIFF(MONTH,DATEADD(MONTH, DATEDIFF(MONTH, 0, C.ProximaCalibracion), 0),GETDATE())>0 AND C.fechaEjecutada is null";
		
		try {
			p = con.prepareStatement(querySql);
			r= p.executeQuery();
			return mapper.findCalibrations(r);
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
	public ArrayList<DtoProveedor> getProviders(DtoProveedor equipo,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql=sqlProperties.getProperty("provider.select");
		try {
			p = con.prepareStatement(querySql);
			r= p.executeQuery();
			return mapperProvider.findProviders(r);
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
	public DtoCalibracion deleteCalibration(DtoCalibracion calibration,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("calibration.delete");
		try {
			p = con.prepareStatement(querySql);
			p.setString(1,calibration.getCodigoCalibracion());

			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				updateScheduledDelete(calibration,con);
				return calibration;
			}else{
				throw new JankinsMarshallException("No se pudo eliminar la calibracion");
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
	

}
