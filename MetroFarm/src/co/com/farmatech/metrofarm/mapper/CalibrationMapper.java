package co.com.farmatech.metrofarm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.jankins.psf.common.exception.JankinsMarshallException;

import com.co.farmatech.metrofarm.dto.DtoCalibracion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;

public class CalibrationMapper {
	
	public ArrayList<DtoCalibracion> findCalibrations(ResultSet resultSet){
		ArrayList<DtoCalibracion> calibracionList=new ArrayList<DtoCalibracion>();
		try {
			while(resultSet.next()){
				//Equipos
				DtoCalibracion calibracion = new DtoCalibracion();
				calibracion.setCodigoCalibracion(resultSet.getString("codigoCalibracion"));
				calibracion.setDivision(resultSet.getString("division"));
				calibracion.setExactitud(resultSet.getString("exactitud"));
				calibracion.setValMaximo(resultSet.getString("valorMaximo"));
				calibracion.setValMininmo(resultSet.getString("valorMinimo"));
				calibracion.setRangCalibracion(resultSet.getString("rangoCalibracion"));
				calibracion.setRangTrabajo(resultSet.getString("rangoTrabajo"));
				calibracion.setProveedor(resultSet.getString("proveedor"));
				calibracion.setFechaRegistro(resultSet.getTimestamp("fechaRegistro"));
				calibracion.setProximaCalibracion(resultSet.getTimestamp("ProximaCalibracion"));
				calibracion.setFechaEjecutada(resultSet.getTimestamp("fechaEjecutada"));
				calibracion.setCumplio(resultSet.getInt("ejecutadaProxima"));
				calibracion.setArchivo(resultSet.getBytes("documentoCalibracion"));
				calibracion.setPrecio(resultSet.getBigDecimal("precioCalibracion"));
				
				DtoEquipo equipo = new DtoEquipo();
				equipo.setCodigoInv(resultSet.getString("codigoInventario"));
				equipo.setCodigoMet(resultSet.getString("codigoMetrologia"));
				equipo.setSerie(resultSet.getString("numeroSerie"));
				equipo.setNombre(resultSet.getString("nombreEquipo"));
				equipo.setMarca(resultSet.getString("marca"));
				equipo.setModelo(resultSet.getString("modelo"));
				equipo.setUbicacion(resultSet.getString("ubicacion"));
				equipo.setFecha(resultSet.getTimestamp("fechaRegistroEquipo"));
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
				calibracion.setEquipo(equipo);
				calibracionList.add(calibracion);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findCalibrations",e);
		}
		
		return calibracionList;
	}

}
