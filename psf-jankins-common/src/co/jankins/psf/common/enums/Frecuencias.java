package co.jankins.psf.common.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Frecuencias {
	
	NOAPLICA(-1L,"No Aplica"),
	UNMES(1L,"1 Mes"),
	DOSMESES(2L,"2 Meses"),
	TRESMESES(3L,"3 Meses"),
	CUATROMESES(4L,"4 Meses"),
	CINCOMESES(5L,"5 Meses"),
	SEISMESES(6L,"6 Meses"),
	SIETEMESES(7L,"7 Meses"),
	OCHOMESES(8L,"8 Meses"),
	NUEVEMESES(9L,"9 Meses"),
	DIEZMESES(10L,"10 Meses"),
	ONCEMESES(11L,"11 Meses"),
	DOCEMESES(12L,"12 Meses"),
	TRECEMESES(13L,"13 Meses"),
	CATORCEMESES(14L,"14 Meses"),
	QUINCEMESES(15L,"15 Meses"),
	DIECISEISMESES(16L,"16 Meses"),
	DIECISIETEMESES(17L,"17 Meses"),
	DIECISOCHOMESES(18L,"18 Meses"),
	DIECINUEVEMESES(19L,"19 Meses"),
	VEINTEMESES(20L,"20 Meses"),
	VEINTIUNOMESES(21L,"21 Meses"),
	VEINTIDOSMESES(22L,"22 Meses"),
	VEINTITRESMESES(23L,"23 Meses"),
	VEINTCUATROMESES(24L,"24 Meses");
	
	
	/** The Constant lookup. */
	private static final Map<Long, Frecuencias> lookup = new HashMap<Long, Frecuencias>();


	static {
		for (Frecuencias st : EnumSet
				.allOf(Frecuencias.class)) {
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
	private Frecuencias(Long code, String description) {
		this.description = description;
		this.code = code;
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 */
	public static Frecuencias getByCode(Long code){
		Frecuencias status = null;
		for(Frecuencias s : EnumSet.allOf(Frecuencias.class)){
			Frecuencias statusAux = (Frecuencias)lookup.get(s.getCode());
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
	public static Frecuencias getByDescription(String description){
		Frecuencias status = null;
		for(Frecuencias s : EnumSet.allOf(Frecuencias.class)){
			Frecuencias statusAux = (Frecuencias)lookup.get(s.getCode());
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
