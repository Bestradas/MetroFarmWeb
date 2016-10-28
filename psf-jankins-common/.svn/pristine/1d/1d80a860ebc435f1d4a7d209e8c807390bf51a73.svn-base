package co.jankins.psf.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TipoCalificacion {
	
	CALIFICACION_OPERACION(1L,"Calificacion operación"),
	CALIFICACION_DESEMPENIO(2L,"Calificacion desempeño");
	
	/** The Constant lookup. */
	private static final Map<Long, TipoCalificacion> lookup = new HashMap<Long, TipoCalificacion>();


	static {
		for (TipoCalificacion st : EnumSet
				.allOf(TipoCalificacion.class)) {
			lookup.put(st.getCode(), st);
		}
	}
	
	/**
	 * Real code of the object.
	 */
	private Long code;

	/** Description of the object. */
	private String nombre;

	/**
	 * Default constructor.
	 *
	 * @param code the code
	 * @param description the description
	 */
	private TipoCalificacion(Long code, String description) {
		this.nombre = description;
		this.code = code;
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public static TipoCalificacion getByCode(Long code){
		TipoCalificacion tipo = null;
		for(TipoCalificacion s : EnumSet.allOf(TipoCalificacion.class)){
			TipoCalificacion tipoAux = (TipoCalificacion)lookup.get(s.getCode());
			 if (tipoAux.getCode().equals(code)){
				 tipo=tipoAux;
				 break;
			 }	 
		}
		return tipo;
	}
	
	/**
	 * 
	 * @param nombre
	 * @return
	 */
	public static TipoCalificacion getByNombre(String nombre){
		TipoCalificacion tipo = null;
		for(TipoCalificacion s : EnumSet.allOf(TipoCalificacion.class)){
			TipoCalificacion tipoAux = (TipoCalificacion)lookup.get(s.getCode());
			 if (tipoAux.getNombre().equals(nombre)){
				 tipo=tipoAux;
				 break;
			 }	 
		}
		return tipo;
	}
	
	

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
