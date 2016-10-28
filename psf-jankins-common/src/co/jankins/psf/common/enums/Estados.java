package co.jankins.psf.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


public enum Estados {
	
	DESACTIVADO(0L,"DESACTIVADO"),
	ACTIVADO(1L,"ACTIVADO");
	
	/** The Constant lookup. */
	private static final Map<Long, Estados> lookup = new HashMap<Long, Estados>();


	static {
		for (Estados st : EnumSet
				.allOf(Estados.class)) {
			lookup.put(st.getCode(), st);
		}
	}
	
	/**
	 * Real code of the error.
	 */
	private Long code;

	/** Description of the error. */
	private String description;

	/**
	 * Default constructor.
	 *
	 * @param code the code
	 * @param description the description
	 */
	private Estados(Long code, String description) {
		this.description = description;
		this.code = code;
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public static Estados getByCode(Long code){
		Estados status = null;
		for(Estados s : EnumSet.allOf(Estados.class)){
			Estados statusAux = (Estados)lookup.get(s.getCode());
			 if (statusAux.getCode().equals(code)){
				 status=statusAux;
				 break;
			 }	 
		}
		return status;
	}
	
	/**
	 * 
	 * @param description
	 * @return
	 */
	public static Estados getByDescription(String description){
		Estados status = null;
		for(Estados s : EnumSet.allOf(Estados.class)){
			Estados statusAux = (Estados)lookup.get(s.getCode());
			 if (statusAux.getDescription().equals(description)){
				 status=statusAux;
				 break;
			 }	 
		}
		return status;
	}
	
	

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

	
	
	

}
