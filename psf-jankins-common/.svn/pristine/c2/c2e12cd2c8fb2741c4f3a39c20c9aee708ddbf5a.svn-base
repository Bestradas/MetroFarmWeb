package co.jankins.psf.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TipoEquipo {
	
	EQUIPO(1L,"Equipo"),
	INSTRUMENTO(2L,"Instrumento");
	
	/** The Constant lookup. */
	private static final Map<Long, TipoEquipo> lookup = new HashMap<Long, TipoEquipo>();


	static {
		for (TipoEquipo st : EnumSet
				.allOf(TipoEquipo.class)) {
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
	private TipoEquipo(Long code, String description) {
		this.nombre = description;
		this.code = code;
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public static TipoEquipo getByCode(Long code){
		TipoEquipo tipo = null;
		for(TipoEquipo s : EnumSet.allOf(TipoEquipo.class)){
			TipoEquipo tipoAux = (TipoEquipo)lookup.get(s.getCode());
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
	public static TipoEquipo getByNombre(String nombre){
		TipoEquipo tipo = null;
		for(TipoEquipo s : EnumSet.allOf(TipoEquipo.class)){
			TipoEquipo tipoAux = (TipoEquipo)lookup.get(s.getCode());
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
