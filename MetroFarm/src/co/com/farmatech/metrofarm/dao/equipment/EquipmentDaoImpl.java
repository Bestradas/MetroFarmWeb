package co.com.farmatech.metrofarm.dao.equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.com.farmatech.metrofarm.mapper.EquipmentMapper;
import co.com.farmatech.metrofarm.properties.AccessMetroFarmProperties;
import co.jankins.psf.common.enums.TipoEquipo;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.global.GlobalUtils;

import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.PageData;

public class EquipmentDaoImpl implements EquipmentDaoService{

	private Properties sqlProperties = AccessMetroFarmProperties.getInstance().getSQLProperties();
	EquipmentMapper equipMapper=new EquipmentMapper();

	@Override
	public ArrayList<DtoEquipo> findEquipment(DtoEquipo equipo,
			Connection con,PageData pageData) {
		// TODO Auto-generated method stub
		ArrayList<DtoEquipo> equipos=new ArrayList<DtoEquipo>();
		List<Object> params=new ArrayList<Object>();
		PreparedStatement p = null;
		ResultSet r;

		String querySql=sqlProperties.getProperty("equipment.findEquipment");
		String q=sqlProperties.getProperty("equipment.findEquipmentCount");
		String alternativeQuery="";

		if(equipo.getCodigoInv()!=null){
			alternativeQuery+=" AND UPPER(codigoInventario)=UPPER(?)";
			params.add(equipo.getCodigoInv());
		}
		if(equipo.getCodigoMet()!=null){
			alternativeQuery+=" AND UPPER(codigoMetrologia)=UPPER(?)";
			params.add(equipo.getCodigoMet());
		}
		if(equipo.getSerie()!=null){
			alternativeQuery+=" AND UPPER(numeroSerie)=UPPER(?)";
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
			r = p.executeQuery();
			equipos=equipMapper.findEquipments(r);
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new JankinsMarshallException("Ocurrio un error realizando el rollback",e);
			}
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

		return equipos;

	}

	@Override
	public DtoEquipo createEquipment(DtoEquipo equipo,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;		
		try {
			p = con.prepareStatement(sqlProperties.getProperty("equipment.createEquipment"));
			p.setString(1, equipo.getCodigoInv());
			p.setString(2, equipo.getCodigoMet());
			p.setString(3, equipo.getSerie());
			p.setString(4, equipo.getNombre());
			p.setString(5, equipo.getMarca());
			p.setString(6, equipo.getModelo());
			p.setString(7, equipo.getUbicacion());
			p.setString(8, equipo.getCliente());
			p.setLong(9, equipo.getTipo());
			p.setLong(10, equipo.getFrecCalibracion());
			p.setLong(11, equipo.getFrecMantenimiento());
			p.setLong(12, equipo.getFrecCalifOPerativa());
			p.setLong(13, equipo.getFrecCalifDesempenio());
			p.setBytes(14, equipo.getFoto());
			p.setString(15, equipo.getExtencion());
			p.setLong(16, equipo.getEstado());
			p.setString(17, equipo.getObservaciones());
			int rowsAfect = p.executeUpdate();
			if(rowsAfect>0){
				return equipo;
			}else {
				throw new JankinsMarshallException("No se pudo crear el nuevo equipo");
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	public DtoEquipo updateEquipment(DtoEquipo equipo,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;		
		try {
			p = con.prepareStatement(sqlProperties.getProperty("equipment.updateEquipment"));
			p.setString(1, equipo.getCodigoMet());
			p.setString(2, equipo.getUbicacion());
			p.setLong(3, equipo.getTipo());
			p.setLong(4, equipo.getFrecCalibracion());
			p.setLong(5, equipo.getFrecMantenimiento());
			p.setLong(6, equipo.getFrecCalifOPerativa());
			p.setLong(7, equipo.getFrecCalifDesempenio());
			p.setBytes(8, equipo.getFoto());
			p.setLong(9, equipo.getEstado());
			p.setString(10, equipo.getObservaciones());
			p.setString(11, equipo.getCodigoInv());
			int rowsAfect = p.executeUpdate();
			if(rowsAfect>0){
				return equipo;
			}else{
				throw new JankinsMarshallException("No se pudo actualizar el equipo el registro");
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	public DtoEquipo findEquipmentExist(DtoEquipo equipo,
			Connection con) {
		// TODO Auto-generated method stub
		ArrayList<DtoEquipo> equipos=new ArrayList<DtoEquipo>();
		List<Object> params=new ArrayList<Object>();
		PreparedStatement p = null;
		ResultSet r;

		String querySql=sqlProperties.getProperty("equipment.findEquipmentExist");

		try {
			p = con.prepareStatement(querySql);
			p.setString(1,equipo.getCodigoInv());
			p.setString(2,equipo.getCodigoMet());
			p.setString(3,equipo.getSerie());
			r = p.executeQuery();
			if(equipMapper.findEquipmentsExist(r)){
				return equipo;
			}else
				return null;
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new JankinsMarshallException("Ocurrio un error realizando el rollback",e);
			}
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
	public boolean validateMaintanencesRegister(DtoEquipo equipo,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		boolean valid=false;
		String property=equipo.getTipo().equals(TipoEquipo.INSTRUMENTO.getCode())?"equipment.validChangeTypeManInst":"equipment.validChangeTypeManEquipo";
		String querySql=sqlProperties.getProperty(property);

		try {
			p = con.prepareStatement(querySql);
			p.setString(1,equipo.getCodigoInv());
			r = p.executeQuery();
			return equipMapper.validChangeType(r);
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
