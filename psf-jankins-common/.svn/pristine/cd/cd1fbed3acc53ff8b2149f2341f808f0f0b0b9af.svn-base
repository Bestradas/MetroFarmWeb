package co.jankins.psf.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TipoDocumento {
	CC(1L,"Cédula de ciudadania"),
	TI(2L,"Tarjeta de identidad");
	
	/** The Constant lookup. */
	private static final Map<Long, TipoDocumento> lookup = new HashMap<Long, TipoDocumento>();


	static {
		for (TipoDocumento st : EnumSet
				.allOf(TipoDocumento.class)) {
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
	private TipoDocumento(Long code, String description) {
		this.nombre = description;
		this.code = code;
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public static TipoDocumento getByCode(Long code){
		TipoDocumento tipo = null;
		for(TipoEquipo s : EnumSet.allOf(TipoEquipo.class)){
			TipoDocumento tipoAux = (TipoDocumento)lookup.get(s.getCode());
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
	public static TipoDocumento getByNombre(String nombre){
		TipoDocumento tipo = null;
		for(TipoDocumento s : EnumSet.allOf(TipoDocumento.class)){
			TipoDocumento tipoAux = (TipoDocumento)lookup.get(s.getCode());
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
