package co.com.farmatech.metrofarm.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import co.jankins.psf.common.exception.JankinsMarshallException;

public class DataSourceConnector {
	
	private static DataSourceConnector instance;
	
	private DataSource dataSource;

//	private final Properties properties = new AccessMetroFarmProperties().getBDProperties();

	
	public static synchronized DataSourceConnector getInstance(){
		if (instance == null) {
			instance = new DataSourceConnector();
			return instance;
		}
		return instance;
	}
	
	
	/**
	 * Metodo constructor de la clase principal, que permite iniciar la variable
	 * que contiene la biblioteca de datos del objeto enviado y creacion del
	 * script.
	 *
	 * @param
	 * @author bestrada
	 */
	public DataSourceConnector() {
		initDataSource(); //Extrae la informacion del archivo de configuracion
	}


	/**
	 * Metodo que permite crear la conexion apartir del archivo de confoguracion
	 * de la conexion.
	 *
	 * @param
	 * @return DataSource
	 * @author bestrada
	 */
	public void initDataSource() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/MetroFarm");
//			basicDataSource.setDriverClassName( properties.getProperty("driverClassName") );
//			basicDataSource.setUsername( properties.getProperty("username") );
//			basicDataSource.setPassword( properties.getProperty("password") );
//			basicDataSource.setUrl( properties.getProperty("url") );
//			basicDataSource.getConnection().setAutoCommit(false);
			dataSource=ds;
		} catch (NamingException ex) {
			throw new JankinsMarshallException(ex,"999");
		}
		}

	/**
	 * Metodo que retorna la conexion disponible segun el pool de conexiones
	 * creada con el BasicDataSource.
	 *
	 * @param
	 * @return Connection
	 * @author bestrada
	 */
	public Connection getConexion() {
		try {
			// BasicDataSource nos reserva una conexion y nos la devuelve.
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new JankinsMarshallException("Ha ocurrido un error obteniendo la conexion",e);
		}
	}

	/**
	 * Metodo que cierra la conexion inicializada.
	 *
	 * @param
	 * @return void
	 * @author bestrada
	 */
	public void liberaConexion() {
		try {
			if (null != this.getConexion()) 
				if(!this.getConexion().isClosed()){
					this.getConexion().close();
				}
		} catch (SQLException e) {
			throw new JankinsMarshallException("Ha ocurrido un error liberando la conexion",e);

		}
	}

	/**
	 * Metodo que cierra la conexion inicializada.
	 *
	 * @param
	 * @return void
	 * @author bestrada
	 */
	public void close() {
		try {
			if (null != this.getConexion()) 
				this.getConexion().close();
		} catch (SQLException e) {
			throw new JankinsMarshallException("Ha ocurrido un error cerrando la conexion");

		}
	}

	/**
	 * Metodo devuelve los cambios hechos en la conexion.
	 *
	 * @param
	 * @return void
	 * @author bestrada
	 */
	public void rollback() {
		try {
			if (null != this.getConexion()) 
				this.getConexion().rollback();
		} catch (SQLException e) {
			throw new JankinsMarshallException("Ha ocurrido un error en el rollback",e);

		}
	}

	/**
	 * Metodo hace efectiva las acciones hechas en la conexion 
	 *
	 * @param
	 * @return void
	 * @author bestrada
	 */
	public void commit() {
		try {
			if (null != this.getConexion()) 
				this.getConexion().commit();
		} catch (SQLException e) {
			throw new JankinsMarshallException("Ha ocurrido un error confirmando los cambios en la conexion",e);

		}
	}

}
