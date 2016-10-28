package co.com.farmatech.metrofarm.dao.calification;

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
import co.com.farmatech.metrofarm.mapper.CalificationMapper;
import co.com.farmatech.metrofarm.properties.AccessMetroFarmProperties;
import co.jankins.psf.common.exception.JankinsMarshallException;

import com.co.farmatech.metrofarm.dto.DtoCalificacion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProgramCalificacion;

public class CalificationDaoImpl implements CalificationDaoService{
	
	private Properties sqlProperties = AccessMetroFarmProperties.getInstance().getSQLProperties();
	CalificationMapper mapper=new CalificationMapper();
	
	@Override
	public ArrayList<DtoCalificacion> findCalification(DtoEquipo equipo, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql=sqlProperties.getProperty("califiation.select");
		if(equipo.getCodigoInv()!=null){
			querySql+=" AND UPPER(E.codigoInventario)=UPPER(?)";
			params.add(equipo.getCodigoInv());
		}
		if(equipo.getCodigoMet()!=null){
			querySql+=" AND UPPER(E.codigoMetrologia)=UPPER(?)";
			params.add(equipo.getCodigoMet());
		}
		if(equipo.getSerie()!=null){
			querySql+=" AND UPPER(E.numeroSerie)=UPPER(?)";
			params.add(equipo.getSerie());
		}
		
		try {
			p = con.prepareStatement(querySql);
			for (int i = 0; i < params.size(); i++) {
				p.setString(i+1,(String)params.get(i));
			}
			r= p.executeQuery();
			return mapper.findCalifications(r);
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
	public DtoCalificacion createFirstCalification(DtoCalificacion calification, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("califiation.save");
		try {
			p = con.prepareStatement(querySql);
			p.setString(1,calification.getEquipo().getCodigoInv());
			p.setBytes(2,calification.getFileDiseno());
			p.setBytes(3,calification.getFileInstalacion());
			p.setBytes(4,calification.getFileOperacion());
			p.setBytes(5,calification.getFiledesempeno());
			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				return calification;
			}else{
				throw new JankinsMarshallException("No se pudo crear la calificacion");
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
	public DtoCalificacion createCalification(DtoCalificacion calification, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("califiation.update");
		try {
			p = con.prepareStatement(querySql);
			p.setBytes(1,calification.getFileDiseno());
			p.setBytes(2,calification.getFileInstalacion());
			p.setBytes(3,calification.getFileOperacion());
			p.setBytes(4,calification.getFiledesempeno());
			p.setString(5,calification.getEquipo().getCodigoInv());
			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				if(calification.getProgramCalif()!=null && !calification.getProgramCalif().isEmpty()){
					for (DtoProgramCalificacion programCalif : calification.getProgramCalif()) {
						programCalification(programCalif, con);
					}
				}
				return calification;
			}else{
				throw new JankinsMarshallException("No se pudo crear la calificacion");
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
	public boolean EquipmentCalification(DtoEquipo equipo, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("equipment.califiation");
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
	public boolean programCalification(DtoProgramCalificacion calificationProg, Connection con) {
		// TODO Auto-generated method stub
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("califiation.program.save");
		try {
			p = datasource.getConexion().prepareStatement(querySql);
			p.setString(1,calificationProg.getEquipo().getCodigoInv());
			p.setLong(2,calificationProg.getTipoCalificacion());
			p.setTimestamp(3,new java.sql.Timestamp(calificationProg.getFechaRegistro().getTime()));
			p.setTimestamp(4,new java.sql.Timestamp(calificationProg.getFechaProxima().getTime()));
			p.setInt(5,calificationProg.getCumplimiento());
			int rowAfect = p.executeUpdate();
			if(rowAfect>0){
				UpdateScheduled(calificationProg, datasource.getConexion());
				return true;
			}else{
				throw new JankinsMarshallException("No se pudo crear la calificacion");
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
	
	
	public void UpdateScheduled(DtoProgramCalificacion calificationProg,Connection con){
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("califiation.program.selectBefore");
		try {
			p = con.prepareStatement(querySql);	
			p.setString(1,calificationProg.getEquipo().getCodigoInv());
			p.setTimestamp(2,new Timestamp(calificationProg.getFechaRegistro().getTime()));
			p.setLong(3, calificationProg.getTipoCalificacion());
			r= p.executeQuery();
			ArrayList<DtoProgramCalificacion> calificationBefores=mapper.findProgrammingCalifications(r);
			if(calificationBefores!=null && !calificationBefores.isEmpty()){
				DtoProgramCalificacion calificationUpdate=calificationBefores.get(0);
				calificationUpdate.setFechaEjecucion(calificationProg.getFechaRegistro());
				SimpleDateFormat formateador = new SimpleDateFormat("MM/yyyy");
				if(formateador.format(calificationUpdate.getFechaEjecucion()).equals(formateador.format(calificationUpdate.getFechaProxima()))){
					calificationUpdate.setCumplimiento(1);
				}else{
					calificationUpdate.setCumplimiento(0);
				}
				DataSourceConnector datasource = DataSourceConnector.getInstance();
				updateProgramming(calificationUpdate, datasource.getConexion());
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
	public void updateProgramming(DtoProgramCalificacion calificationProg,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		String querySql=sqlProperties.getProperty("calification.program.update");
		try {
			p = con.prepareStatement(querySql);
			p.setTimestamp(1,new java.sql.Timestamp(calificationProg.getFechaEjecucion().getTime()));
			p.setInt(2,calificationProg.getCumplimiento());
			p.setLong(3,calificationProg.getCodigoProgramacion());
			p.executeUpdate();
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
	public ArrayList<DtoProgramCalificacion> findCalificationMonthScheduled(
			DtoEquipo equipo, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql=sqlProperties.getProperty("califiation.program.select");

		querySql+=" AND DATEDIFF(MONTH,DATEADD(MONTH, DATEDIFF(MONTH, 0, proximaCalificacion), 0),GETDATE())=0 AND fechaEjecutada is null";
		
		try {
			p = con.prepareStatement(querySql);
			r= p.executeQuery();
			return mapper.findProgrammingCalifications(r);
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
	public ArrayList<DtoProgramCalificacion> findCalificationMonthExpired(
			DtoEquipo equipo, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql=sqlProperties.getProperty("califiation.program.select");
		
		querySql+=" AND DATEDIFF(MONTH,DATEADD(MONTH, DATEDIFF(MONTH, 0, proximaCalificacion), 0),GETDATE())>0 AND fechaEjecutada is null";
		
		try {
			p = con.prepareStatement(querySql);
			r= p.executeQuery();
			return mapper.findProgrammingCalifications(r);
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
	public ArrayList<DtoProgramCalificacion> findCalificationProgramming(
			DtoEquipo equipo, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		List<Object> params=new ArrayList<Object>();
		String querySql=sqlProperties.getProperty("califiation.program.select");
		
		try {
			p = con.prepareStatement(querySql);
			r= p.executeQuery();
			return mapper.findProgrammingCalifications(r);
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
