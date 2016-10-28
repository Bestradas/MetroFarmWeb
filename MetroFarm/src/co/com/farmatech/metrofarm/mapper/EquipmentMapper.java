package co.com.farmatech.metrofarm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import co.jankins.psf.common.exception.JankinsMarshallException;

import com.co.farmatech.metrofarm.dto.DtoEquipo;

public class EquipmentMapper {
	
	public ArrayList<DtoEquipo> findEquipments(ResultSet resultSet){
		ArrayList<DtoEquipo> equiposList=new ArrayList<DtoEquipo>();
		try {
			while(resultSet.next()){
				//Equipos
				DtoEquipo equipo = new DtoEquipo();
				equipo.setCodigoInv(resultSet.getString("codigoInventario"));
				equipo.setCodigoMet(resultSet.getString("codigoMetrologia"));
				equipo.setSerie(resultSet.getString("numeroSerie"));
				equipo.setNombre(resultSet.getString("nombreEquipo"));
				equipo.setMarca(resultSet.getString("marca"));
				equipo.setModelo(resultSet.getString("modelo"));
				equipo.setUbicacion(resultSet.getString("ubicacion"));
				equipo.setFecha(resultSet.getTimestamp("fechaRegistro"));
				equipo.setCliente(resultSet.getString("clienteRegistro"));
				equipo.setTipo(resultSet.getLong("idTipoEquipo"));
				equipo.setFrecMantenimiento(resultSet.getLong("frecuenciaMantenimiento"));
				equipo.setFrecCalibracion(resultSet.getLong("frecuenciaCalibacion"));
				equipo.setFrecCalifOPerativa(resultSet.getLong("frecuenciaCalifiOperativa"));
				equipo.setFrecCalifDesempenio(resultSet.getLong("frecuenciaCalifiDesempeno"));
				equipo.setExtencion(resultSet.getString("extencionFoto"));
				equipo.setEstado(resultSet.getLong("estado"));
				equipo.setObservaciones(resultSet.getString("observaciones"));
				equipo.setFoto(resultSet.getBytes("fotoEquipo"));
				equiposList.add(equipo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findEquipments",e);
		}
		
		return equiposList;
	}

	public boolean findEquipmentsExist(ResultSet resultSet){
		try {
			if(resultSet.next()){
				//Equipos
				if(resultSet.getInt("existe")>0){
					return true;
				}else{
					return false;
				}
			}else{
				throw new JankinsMarshallException("El result set de findEquipmentsExist esta vacio");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findEquipmentsExist",e);
		}
	}
	
	public boolean validChangeType(ResultSet resultSet){
		try {
			if(resultSet.next()){
				//Equipos
				if(resultSet.getInt("numeroMantenimientos")>0){
					return false;
				}else{
					return true;
				}
			}else{
				throw new JankinsMarshallException("El result set de validChangeType esta vacio");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de validChangeType",e);
		}
	}
	
}
