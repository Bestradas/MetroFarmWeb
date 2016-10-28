package co.com.farmatech.metrofarm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import co.jankins.psf.common.exception.JankinsMarshallException;

import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoRegistroCambios;

public class ChangeRegisterMapper {
	
	public DtoRegistroCambios findChangeRegister(ResultSet resultSet){
		DtoRegistroCambios dtoRegistroCambios=null;
		try {
			while(resultSet.next()){
				//Equipos
				dtoRegistroCambios = new DtoRegistroCambios();
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findChangeRegister",e);
		}
		
		return dtoRegistroCambios;
	}
	
	public ArrayList<DtoRegistroCambios> listChangeRegister(ResultSet resultSet){
		ArrayList<DtoRegistroCambios> dtoRegistroCambios=new ArrayList<DtoRegistroCambios>();
		try {
			while(resultSet.next()){
				//Registros cambios
				DtoRegistroCambios registroCambio = new DtoRegistroCambios();
				DtoEquipo equipo=new DtoEquipo();
				equipo.setCodigoInv(resultSet.getString("codigoInventario"));
				equipo.setNombre(resultSet.getString("nombreEquipo"));
				registroCambio.setEquipoRegistro(equipo);
				
				registroCambio.setAplicado(resultSet.getString("aplicado"));
				registroCambio.setCual(resultSet.getString("cual"));
				registroCambio.setSolicitado(resultSet.getString("solicitado"));
				registroCambio.setFecha(resultSet.getTimestamp("fechaSolicitud"));
				registroCambio.setArea(resultSet.getString("area"));
				registroCambio.setPrioridad(resultSet.getString("prioridad"));
				registroCambio.setTipodoc(resultSet.getString("tipoDocumento"));
				registroCambio.setOtro(resultSet.getString("otro"));
				registroCambio.setSituactual(resultSet.getString("situacionActual"));
				registroCambio.setSitupropuesta(resultSet.getString("situacionPropuesta"));
				registroCambio.setRazoncambio(resultSet.getString("razon"));
				registroCambio.setClasifcambio(resultSet.getString("clasificacion"));
				registroCambio.setTipocambio(resultSet.getString("tipoCambio"));
				registroCambio.setLote(resultSet.getString("lote"));
				registroCambio.setOp(resultSet.getString("op"));
				registroCambio.setTamno(resultSet.getString("tamano"));
				registroCambio.setJustificacion(resultSet.getString("justificacion"));
				registroCambio.setCodigo(resultSet.getString("idSolicitud"));
				
				dtoRegistroCambios.add(registroCambio);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findChangeRegister",e);
		}
		
		return dtoRegistroCambios;
	}

}
