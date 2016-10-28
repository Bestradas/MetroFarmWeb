package co.jankins.properties;

import java.util.Properties;

import co.jankins.psf.common.exception.JankinsMarshallException;

public class AccessProperties {

	private static AccessProperties instance;
	
	private Properties properties;

	/**
	 * Metodo que permite instanciar una sola vez la clase de AccessProperties
	 * 
	 * @return
	 * @author Bryan
	 */
	public static synchronized AccessProperties getInstance(){
		if (instance == null) {
			instance = new AccessProperties();
			instance.initProperties();
			return instance;
		}
		return instance;
	}

	/**
	 * Metodo que permite obtener los datos del archivo de configuracion
	 * para la conexion.
	 *  
	 * @return Properties
	 * @author Bryan
	 */
	public void initProperties(){
		try {
			//se crea una instancia a la clase Properties
			Properties properties = new Properties();
			//se leen el archivo .properties
			properties.load( getClass().getResourceAsStream("../../../../properties/configprocess.properties") );
			//si el archivo de propiedades NO esta vacio retornan las propiedes leidas
			if (!properties.isEmpty()){
				this.properties=properties;
			}else{
				throw new JankinsMarshallException("El archivo de propiedades esta vacio");
			}

		} catch (Exception e) {
			throw new JankinsMarshallException("No se pudieron obtener las propiedades de Procesamiento de servicios", e);
		}
	}
	
	public Properties getProperties(){
		return properties;
	}
	

}