package co.com.farmatech.metrofarm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.jankins.psf.common.exception.JankinsMarshallException;

import com.co.farmatech.metrofarm.dto.DtoUsuario;
import com.co.farmatech.metrofarm.dto.DtoPerfil;
import com.sun.crypto.provider.RSACipher;

public class UserMapper {
	
	
	public DtoUsuario authenticateUserMapper(ResultSet resultSet){
		DtoUsuario usuarios=null;
		try {
			if(resultSet.next()){
				//Usuario
				usuarios = new DtoUsuario();
				usuarios.setCodigo(resultSet.getString("numeroId"));
				usuarios.setTipo(resultSet.getLong("idDocumento"));
				usuarios.setNombres(resultSet.getString("nombresUsuario"));
				usuarios.setApellidos(resultSet.getString("apellidosUsuario"));
				usuarios.setCorreo(resultSet.getString("emailUsuario"));
				usuarios.setTelefono1(resultSet.getString("telefonoUsuario"));
				usuarios.setTelefono2(resultSet.getString("telefono2Usuario"));
				usuarios.setCelular(resultSet.getString("celularUsuario"));
				usuarios.setUsuario(resultSet.getString("usuario"));
				usuarios.setContrasena(resultSet.getString("contrasena"));
				usuarios.setPregunta(resultSet.getString("preguntaSeguridad"));
				usuarios.setRespuesta(resultSet.getString("respuestaSeguridad"));
				usuarios.setIdPerfil(resultSet.getLong("idPerfil"));
				usuarios.setEstado(resultSet.getLong("estadoUsuario"));
//				
				//Perfil
				DtoPerfil perfil=new DtoPerfil();
				perfil.setCodperfil(resultSet.getLong("idPerfil"));
				perfil.setPerfil(resultSet.getString("nombrePerfil"));
				perfil.setEstado(resultSet.getLong("estado"));
				perfil.setGuardarUsuariao(resultSet.getBoolean("GuardarUsuariao"));
				perfil.setBuscarUsuario(resultSet.getBoolean("BuscarUsuario"));
				perfil.setModificarUsuario(resultSet.getBoolean("ModificarUsuario"));
				perfil.setEliminarUsuario(resultSet.getBoolean("EliminarUsuario"));
				perfil.setGuardarPerfil(resultSet.getBoolean("GuardarPerfil"));
				perfil.setBuscarPerfil(resultSet.getBoolean("BuscarPerfil"));
				perfil.setModificarPerfil(resultSet.getBoolean("ModificarPerfil"));
				perfil.setEliminarPerfil(resultSet.getBoolean("EliminarPerfil"));
				perfil.setEliminarPerfil(resultSet.getBoolean("EliminarPerfil"));
				perfil.setGuardarEquipo(resultSet.getBoolean("GuardarEquipo"));
				perfil.setBuscarEquipo(resultSet.getBoolean("BuscarEquipo"));
				perfil.setModificarEquipo(resultSet.getBoolean("ModificarEquipo"));
				perfil.setEliminarEquipo(resultSet.getBoolean("EliminarEquipo"));
				perfil.setNotificaEquipos(resultSet.getBoolean("NotificaEquipos"));
				perfil.setGuardarMantenimiento(resultSet.getBoolean("GuardarMantenimiento"));
				perfil.setBuscarMantenimiento(resultSet.getBoolean("BuscarMantenimiento"));
				perfil.setModificarMantenimiento(resultSet.getBoolean("ModificarMantenimiento"));
				perfil.setEliminarMantenimiento(resultSet.getBoolean("EliminarMantenimiento"));
				perfil.setNotificaciones_mant_mes(resultSet.getBoolean("Notificaciones_mant_mes"));
				perfil.setNotificaciones_man_ven_mes(resultSet.getBoolean("Notificaciones_man_ven_mes"));
				perfil.setGuardarCalificacion(resultSet.getBoolean("GuardarCalificacion"));
				perfil.setBuscarCalificacion(resultSet.getBoolean("BuscarCalificacion"));
				perfil.setModificarCalificacion(resultSet.getBoolean("ModificarCalificacion"));
				perfil.setEliminarCalificacion(resultSet.getBoolean("EliminarCalificacion"));
				perfil.setNotificaciones_calif_mes(resultSet.getBoolean("Notificaciones_calif_mes"));
				perfil.setNotificaciones_calif_ven_mes(resultSet.getBoolean("Notificaciones_calif_ven_mes"));
				perfil.setNotificaciones_calif_ven_mes(resultSet.getBoolean("Notificaciones_calif_ven_mes"));
				perfil.setGuardarCalibracion(resultSet.getBoolean("GuardarCalibracion"));
				perfil.setBuscarCalibracion(resultSet.getBoolean("BuscarCalibracion"));
				perfil.setModificarCalibracion(resultSet.getBoolean("ModificarCalibracion"));
				perfil.setEliminarCalibracion(resultSet.getBoolean("EliminarCalibracion"));
				perfil.setNotificaciones_calib_mes(resultSet.getBoolean("Notificaciones_calib_mes"));
				perfil.setNotificaciones_calib_ven(resultSet.getBoolean("Notificaciones_calib_ven"));
				perfil.setGuardarMantGen(resultSet.getBoolean("GuardarMantGen"));
				perfil.setBuscarMantGen(resultSet.getBoolean("BuscarMantGen"));
				perfil.setModificarMantGen(resultSet.getBoolean("ModificarMantGen"));
				perfil.setEliminarMantGen(resultSet.getBoolean("EliminarMantGen"));
				perfil.setNotificacionesMantgenmes(resultSet.getBoolean("Notificaciones_mantgen_mes"));
				perfil.setNotificacionesMantgenvenc(resultSet.getBoolean("Notificaciones_mantgen_vencida"));
				
				usuarios.setPerfil(perfil);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de authenticateUserMapper",e);
		}
		
		return usuarios;
	}
	
	public ArrayList<DtoUsuario> findUserMapper(ResultSet resultSet){
		ArrayList<DtoUsuario> arrayUsuarios=new ArrayList<DtoUsuario>();
		try {
			while(resultSet.next()){
				//Usuario
				DtoUsuario usuarios = new DtoUsuario();
				usuarios.setCodigo(resultSet.getString("numeroId"));
				usuarios.setTipo(resultSet.getLong("idDocumento"));
				usuarios.setNombres(resultSet.getString("nombresUsuario"));
				usuarios.setApellidos(resultSet.getString("apellidosUsuario"));
				usuarios.setCorreo(resultSet.getString("emailUsuario"));
				usuarios.setTelefono1(resultSet.getString("telefonoUsuario"));
				usuarios.setTelefono2(resultSet.getString("telefono2Usuario"));
				usuarios.setCelular(resultSet.getString("celularUsuario"));
				usuarios.setUsuario(resultSet.getString("usuario"));
				usuarios.setContrasena(resultSet.getString("contrasena"));
				usuarios.setPregunta(resultSet.getString("preguntaSeguridad"));
				usuarios.setRespuesta(resultSet.getString("respuestaSeguridad"));
				usuarios.setIdPerfil(resultSet.getLong("idPerfil"));
				usuarios.setEstado(resultSet.getLong("estadoUsuario"));
//				
				//Perfil
				DtoPerfil perfil=new DtoPerfil();
				perfil.setCodperfil(resultSet.getLong("idPerfil"));
				perfil.setPerfil(resultSet.getString("nombrePerfil"));
				perfil.setEstado(resultSet.getLong("estado"));
				perfil.setGuardarUsuariao(resultSet.getBoolean("GuardarUsuariao"));
				perfil.setBuscarUsuario(resultSet.getBoolean("BuscarUsuario"));
				perfil.setModificarUsuario(resultSet.getBoolean("ModificarUsuario"));
				perfil.setEliminarUsuario(resultSet.getBoolean("EliminarUsuario"));
				perfil.setGuardarPerfil(resultSet.getBoolean("GuardarPerfil"));
				perfil.setBuscarPerfil(resultSet.getBoolean("BuscarPerfil"));
				perfil.setModificarPerfil(resultSet.getBoolean("ModificarPerfil"));
				perfil.setEliminarPerfil(resultSet.getBoolean("EliminarPerfil"));
				perfil.setEliminarPerfil(resultSet.getBoolean("EliminarPerfil"));
				perfil.setGuardarEquipo(resultSet.getBoolean("GuardarEquipo"));
				perfil.setBuscarEquipo(resultSet.getBoolean("BuscarEquipo"));
				perfil.setModificarEquipo(resultSet.getBoolean("ModificarEquipo"));
				perfil.setEliminarEquipo(resultSet.getBoolean("EliminarEquipo"));
				perfil.setNotificaEquipos(resultSet.getBoolean("NotificaEquipos"));
				perfil.setGuardarMantenimiento(resultSet.getBoolean("GuardarMantenimiento"));
				perfil.setBuscarMantenimiento(resultSet.getBoolean("BuscarMantenimiento"));
				perfil.setModificarMantenimiento(resultSet.getBoolean("ModificarMantenimiento"));
				perfil.setEliminarMantenimiento(resultSet.getBoolean("EliminarMantenimiento"));
				perfil.setNotificaciones_mant_mes(resultSet.getBoolean("Notificaciones_mant_mes"));
				perfil.setNotificaciones_man_ven_mes(resultSet.getBoolean("Notificaciones_man_ven_mes"));
				perfil.setGuardarCalificacion(resultSet.getBoolean("GuardarCalificacion"));
				perfil.setBuscarCalificacion(resultSet.getBoolean("BuscarCalificacion"));
				perfil.setModificarCalificacion(resultSet.getBoolean("ModificarCalificacion"));
				perfil.setEliminarCalificacion(resultSet.getBoolean("EliminarCalificacion"));
				perfil.setNotificaciones_calif_mes(resultSet.getBoolean("Notificaciones_calif_mes"));
				perfil.setNotificaciones_calif_ven_mes(resultSet.getBoolean("Notificaciones_calif_ven_mes"));
				perfil.setNotificaciones_calif_ven_mes(resultSet.getBoolean("Notificaciones_calif_ven_mes"));
				perfil.setGuardarCalibracion(resultSet.getBoolean("GuardarCalibracion"));
				perfil.setBuscarCalibracion(resultSet.getBoolean("BuscarCalibracion"));
				perfil.setModificarCalibracion(resultSet.getBoolean("ModificarCalibracion"));
				perfil.setEliminarCalibracion(resultSet.getBoolean("EliminarCalibracion"));
				perfil.setNotificaciones_calib_mes(resultSet.getBoolean("Notificaciones_calib_mes"));
				perfil.setNotificaciones_calib_ven(resultSet.getBoolean("Notificaciones_calib_ven"));
				perfil.setGuardarMantGen(resultSet.getBoolean("GuardarMantGen"));
				perfil.setBuscarMantGen(resultSet.getBoolean("BuscarMantGen"));
				perfil.setModificarMantGen(resultSet.getBoolean("ModificarMantGen"));
				perfil.setEliminarMantGen(resultSet.getBoolean("EliminarMantGen"));
				perfil.setNotificacionesMantgenmes(resultSet.getBoolean("Notificaciones_mantgen_mes"));
				perfil.setNotificacionesMantgenvenc(resultSet.getBoolean("Notificaciones_mantgen_vencida"));
				
				usuarios.setPerfil(perfil);
				
				arrayUsuarios.add(usuarios);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findUserMapper",e);
		}
		
		return arrayUsuarios;
	}
	
	public boolean isValidUserCreate(ResultSet r){
		boolean isValid=false;
		try {
			if(r.next()){
				if(r.getInt("existe")>0){
					return false;
				}else{
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de isValidUserCreate",e);
		}
		return isValid;
	}
	
	
	

}
