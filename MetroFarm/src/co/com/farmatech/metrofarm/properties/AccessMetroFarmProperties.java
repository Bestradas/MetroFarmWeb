package co.com.farmatech.metrofarm.properties;

import java.util.Properties;

import co.jankins.psf.common.exception.JankinsMarshallException;

public class AccessMetroFarmProperties {
	
	private static AccessMetroFarmProperties instance;
	
	private Properties properties;

	/**
	 * Metodo que permite instanciar una sola vez la clase de AccessProperties
	 * 
	 * @return
	 * @author Bryan
	 */
	public static synchronized AccessMetroFarmProperties getInstance(){
		if (instance == null) {
			instance = new AccessMetroFarmProperties();
			instance.initSQLProperties();
			return instance;
			
		}
		return instance;
	}

	
	/**
	 * Metodo que iniicializa las propiedades
	 * @return
	 */
	public void initSQLProperties(){
		try {
			//se crea una instancia a la clase Properties
			Properties properties = new Properties();
			//se leen el archivo .properties
			properties.load( getClass().getResourceAsStream("../bdproperties/sql-context.properties") );
			//si el archivo de propiedades NO esta vacio retornan las propiedes leidas
			if (!properties.isEmpty()){
				this.properties=properties;
			}else{
				throw new JankinsMarshallException("El archivo de propiedades esta vacio");
			}

		} catch (Exception e) {
			throw new JankinsMarshallException("No se pudieron obtener las propiedades sql", e);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Properties getSQLProperties(){
		return properties;
	}

}
