package co.jankins.psf.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TipoMantenimiento {
	
	PREVENTIVO(1L,"Preventivo"),
	CORRECTIVO(2L,"Correctivo"),
	PROGRAMADO(3L,"Programado");
	
	/** The Constant lookup. */
	private static final Map<Long, TipoMantenimiento> lookup = new HashMap<Long, TipoMantenimiento>();


	static {
		for (TipoMantenimiento st : EnumSet
				.allOf(TipoMantenimiento.class)) {
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
	private TipoMantenimiento(Long code, String description) {
		this.nombre = description;
		this.code = code;
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public static TipoMantenimiento getByCode(Long code){
		TipoMantenimiento tipo = null;
		for(TipoMantenimiento s : EnumSet.allOf(TipoMantenimiento.class)){
			TipoMantenimiento tipoAux = (TipoMantenimiento)lookup.get(s.getCode());
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
	public static TipoMantenimiento getByNombre(String nombre){
		TipoMantenimiento tipo = null;
		for(TipoMantenimiento s : EnumSet.allOf(TipoMantenimiento.class)){
			TipoMantenimiento tipoAux = (TipoMantenimiento)lookup.get(s.getCode());
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
