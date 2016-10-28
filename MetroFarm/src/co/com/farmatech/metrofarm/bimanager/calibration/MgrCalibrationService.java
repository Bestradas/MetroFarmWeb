package co.com.farmatech.metrofarm.bimanager.calibration;

import java.util.ArrayList;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;

import com.co.farmatech.metrofarm.dto.DtoCalibracion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProveedor;
import com.co.farmatech.metrofarm.dto.PageData;

public interface MgrCalibrationService {

	/**
	 * 
	 * @param calibracion
	 * @param source
	 * @return
	 */
	public DtoCalibracion createFirstCalibration(DtoCalibracion calibracion,DataSourceConnector source);
	
	/**
	 * 
	 * @param calibracion
	 * @param source
	 * @return
	 */
	public DtoCalibracion createCalibration(DtoCalibracion calibracion,DataSourceConnector source);
	
	/**
	 * 
	 * @param calibracion
	 * @param source
	 * @return
	 */
	public DtoCalibracion deleteCalibration(DtoCalibracion calibracion,DataSourceConnector source);
	
	/**
	 * 
	 * @param calibracion
	 * @param source
	 * @return
	 */
	public DtoCalibracion updateCalibration(DtoCalibracion calibracion,DataSourceConnector source);
	
	/**
	 * 
	 * @param equipo
	 * @param source
	 * @return
	 */
	public ArrayList<DtoCalibracion> findCalibrations(DtoEquipo equipo,DataSourceConnector source,PageData pageData);
	
	/**
	 * 
	 * @param calibracion
	 * @param source
	 * @return
	 */
	public ArrayList<DtoCalibracion> findCalibrations(DtoCalibracion calibracion,DataSourceConnector source,PageData pageData);
	
	/**
	 * 
	 * @param equipo
	 * @param source
	 * @return
	 */
	public ArrayList<DtoCalibracion> findCalibrationsMonthScheduled(DtoEquipo equipo,DataSourceConnector source);
	
	/**
	 * 
	 * @param equipo
	 * @param source
	 * @return
	 */
	public ArrayList<DtoCalibracion> findCalibrationsMonthExpired(DtoEquipo equipo,DataSourceConnector source);
	
	/**
	 * 
	 * @param proveedor
	 * @param source
	 * @return
	 */
	public ArrayList<DtoProveedor> getProviders(DtoProveedor proveedor,DataSourceConnector source);

}
