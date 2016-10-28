package co.com.farmatech.metrofarm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.jankins.psf.common.exception.JankinsMarshallException;

import com.co.farmatech.metrofarm.dto.DtoPerfil;

public class ProfileMapper {
	
	public DtoPerfil getProfileByUserMapper(ResultSet r){
		DtoPerfil perfil=null;
		
		try {
			if(r.next()){
				perfil=new DtoPerfil();
				perfil.setBuscarCalibracion(true);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de getProfileByUserMapper",e);
		}
		
		return perfil;
		
	}
	
	public ArrayList<DtoPerfil> findProfiles(ResultSet r){
		ArrayList<DtoPerfil> perfiles=new ArrayList<DtoPerfil>();
		
		try {
			while(r.next()){
				DtoPerfil perfil=new DtoPerfil();
				perfil.setCodperfil(r.getLong("idPerfil"));
				perfil.setPerfil(r.getString("nombrePerfil"));
				perfil.setEstado(r.getLong("estado"));
				perfil.setGuardarUsuariao(r.getBoolean("GuardarUsuariao"));
				perfil.setBuscarUsuario(r.getBoolean("BuscarUsuario"));
				perfil.setModificarUsuario(r.getBoolean("ModificarUsuario"));
				perfil.setEliminarUsuario(r.getBoolean("EliminarUsuario"));
				perfil.setGuardarPerfil(r.getBoolean("GuardarPerfil"));
				perfil.setBuscarPerfil(r.getBoolean("BuscarPerfil"));
				perfil.setModificarPerfil(r.getBoolean("ModificarPerfil"));
				perfil.setEliminarPerfil(r.getBoolean("EliminarPerfil"));
				perfil.setGuardarEquipo(r.getBoolean("GuardarEquipo"));
				perfil.setBuscarEquipo(r.getBoolean("BuscarEquipo"));
				perfil.setModificarEquipo(r.getBoolean("ModificarEquipo"));
				perfil.setEliminarEquipo(r.getBoolean("EliminarEquipo"));
				perfil.setNotificaEquipos(r.getBoolean("NotificaEquipos"));
				perfil.setGuardarMantenimiento(r.getBoolean("GuardarMantenimiento"));
				perfil.setBuscarMantenimiento(r.getBoolean("BuscarMantenimiento"));
				perfil.setModificarMantenimiento(r.getBoolean("ModificarMantenimiento"));
				perfil.setEliminarMantenimiento(r.getBoolean("EliminarMantenimiento"));
				perfil.setNotificaciones_mant_mes(r.getBoolean("Notificaciones_mant_mes"));
				perfil.setNotificaciones_man_ven_mes(r.getBoolean("Notificaciones_man_ven_mes"));
				perfil.setGuardarCalificacion(r.getBoolean("GuardarCalificacion"));
				perfil.setBuscarCalificacion(r.getBoolean("BuscarCalificacion"));
				perfil.setModificarCalificacion(r.getBoolean("ModificarCalificacion"));
				perfil.setEliminarCalificacion(r.getBoolean("EliminarCalificacion"));
				perfil.setNotificaciones_calif_mes(r.getBoolean("Notificaciones_calif_mes"));
				perfil.setNotificaciones_calif_ven_mes(r.getBoolean("Notificaciones_calif_ven_mes"));
				perfil.setGuardarCalibracion(r.getBoolean("GuardarCalibracion"));
				perfil.setBuscarCalibracion(r.getBoolean("BuscarCalibracion"));
				perfil.setModificarCalibracion(r.getBoolean("ModificarCalibracion"));
				perfil.setEliminarCalibracion(r.getBoolean("EliminarCalibracion"));
				perfil.setNotificaciones_calib_mes(r.getBoolean("Notificaciones_calib_mes"));
				perfil.setNotificaciones_calib_ven(r.getBoolean("Notificaciones_calib_ven"));
				perfil.setGuardarMantGen(r.getBoolean("GuardarMantGen"));
				perfil.setBuscarMantGen(r.getBoolean("BuscarMantGen"));
				perfil.setModificarMantGen(r.getBoolean("ModificarMantGen"));
				perfil.setEliminarMantGen(r.getBoolean("EliminarMantGen"));
				perfil.setNotificacionesMantgenmes(r.getBoolean("Notificaciones_mantgen_mes"));
				perfil.setNotificacionesMantgenvenc(r.getBoolean("Notificaciones_mantgen_vencida"));
				perfiles.add(perfil);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findProfiles",e);
		}
		
		return perfiles;
		
	}

}
