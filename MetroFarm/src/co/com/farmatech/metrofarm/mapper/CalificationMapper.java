package co.com.farmatech.metrofarm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.jankins.psf.common.exception.JankinsMarshallException;

import com.co.farmatech.metrofarm.dto.DtoCalificacion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProgramCalificacion;

public class CalificationMapper {
	
//	califiation.selectBefore =  P.tipoCalificacion,P.fechaRegistro,P.proximaCalificacion,P.cumplimiento FROM ProgramacionCalificaciones P INNER JOIN Equipo E ON P.equipoCalificacion=E.codigoInventario WHERE P.equipoCalificacion=? AND P.fechaRegistro<? order by P.fechaRegistro desc;

	
	public ArrayList<DtoProgramCalificacion> findProgrammingCalifications(ResultSet resultSet){
		ArrayList<DtoProgramCalificacion> calificationList=new ArrayList<DtoProgramCalificacion>();
		try {
			while(resultSet.next()){
				//Equipos
				DtoProgramCalificacion calification = new DtoProgramCalificacion();
				calification.setCodigoProgramacion(resultSet.getLong("codigoProgramacion"));
				calification.setTipoCalificacion(resultSet.getLong("tipoCalificacion"));

				calification.setFechaRegistro(resultSet.getTimestamp("fechaRegistro"));
				calification.setFechaProxima(resultSet.getTimestamp("proximaCalificacion"));
				calification.setFechaEjecucion(resultSet.getTimestamp("fechaEjecutada"));
				calification.setCumplimiento(resultSet.getInt("cumplimiento"));
				
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
				calification.setEquipo(equipo);
				calificationList.add(calification);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findCalibrations",e);
		}
		
		return calificationList;
	}
	
	public ArrayList<DtoCalificacion> findCalifications(ResultSet resultSet){
		ArrayList<DtoCalificacion> calificationList=new ArrayList<DtoCalificacion>();
		try {
			while(resultSet.next()){
				//Equipos
				DtoCalificacion calification = new DtoCalificacion();
				calification.setFileDiseno(resultSet.getBytes("calificacionDiseno"));
				calification.setFileInstalacion(resultSet.getBytes("calificacionInstalacion"));
				calification.setFileOperacion(resultSet.getBytes("calificacionOperacion"));
				calification.setFiledesempeno(resultSet.getBytes("calificacionDesempeno"));

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
				calification.setEquipo(equipo);
				calificationList.add(calification);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findCalibrations",e);
		}
		
		return calificationList;
	}

}
