package co.jankins.psf.common.metrofarm.exception;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum JankerExceptionEnum {

	//Errores de MetroFarm
	
	//USERS
	E_00001("00001","Error de conexi\u00F3n"),
	
	//AUTHENTICATION
	/** The E_10000. */
	E_10000("10000","Error de conexi\u00F3n"),

	/** The E_10001. */
	E_10001("10001","Usuario o contrase\u00F1a incorrectos."),

	/** The E_10002. */
	E_10002("10002","El perfil de usuario es inválido o se encuentra desactivado."),

	/** The E_10003. */
	E_10003("10003","Error retornado por el servicio debido a valores inv\u00E1lidos para un campo"),

	//FORGGET PASWORD
	/** The E_10004. */
	E_10004("10004","El documento de usuario buscado no existe"),
	
	E_10005("10005","Ya existe un usuario con con caracteristicas iguales al ingresado"),
	
	E_10006("10005","El usuario se encuentra desactivado."),

	//Context Exception
	
	/** The E_20000. */
	E_20000("20000","No se ha recibido un contexto válido"),
	
	//EQUIPMENT EXCEPTION
	/** The E_30000. */
	E_30000("30000","No se puede cambiar el tipo de equipo porque ya se han registrado mantenimientos asociados a él."),

	//CHANGE REGISTER EXCEPTION
	/** The E_40000. */
	E_40000("40000","El número de solicitud ingresado ya existe."),
	
	//CALIBRATION REGISTER EXCEPTION
	/** The E_50000. */
	E_50000("50000","No se puede registrar la primera calibración al equipo/instrumento porque este ya tiene calibraciones actuales ."),
	
	//MAINTENANCE REGISTER EXCEPTION
	/** The E_60000. */
	E_60000("60000","No se puede registrar el primer mantenimiento al equipo/instrumento porque este ya tiene mantenimientos actuales ."),

	//CALIFICATION REGISTER EXCEPTION
	/** The E_70000. */
	E_70000("70000","No se puede registrar las primeras calificaciones al equipo/instrumento porque este ya tiene calificaciones actuales ."),
	
	E_70001("70001","Ocurrio un error programando las calificaciones."),
	
	//PROFILE_SERVICE

	E_80000("80000",".");
	
	/** The Constant lookup. */
	private static final Map<String, JankerExceptionEnum> lookup = new HashMap<String, JankerExceptionEnum>();

	

	static {
		for (JankerExceptionEnum st : EnumSet
				.allOf(JankerExceptionEnum.class)) {
			lookup.put(st.getValue().toUpperCase(), st);
		}
	}
	/**
	 * Real code of the error.
	 */
	private String value;

	/** Description of the error. */
	private String description;

	/**
	 * Default constructor.
	 *
	 * @param value the value
	 * @param description the description
	 */
	private JankerExceptionEnum(String value, String description) {
		this.description = description;
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Gets the description.
	 *
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
}
