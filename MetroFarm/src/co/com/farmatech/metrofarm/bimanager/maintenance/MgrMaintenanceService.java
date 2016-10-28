package co.com.farmatech.metrofarm.bimanager.maintenance;

import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoMantenimiento;
import com.co.farmatech.metrofarm.dto.PageData;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;


public interface MgrMaintenanceService {
	
	/**
	 * 
	 * @param mantenimiento
	 * @param source
	 * @return
	 */
	public DtoMantenimiento createFirstMaintenance(DtoMantenimiento mantenimiento,DataSourceConnector source);

	/**
	 * 
	 * @param mantenimiento
	 * @param source
	 * @return
	 */
	public DtoMantenimiento createMaintenance(DtoMantenimiento mantenimiento,DataSourceConnector source);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param source
	 * @return
	 */
	public DtoMantenimiento updateMaintenance(DtoMantenimiento mantenimiento,DataSourceConnector source);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param source
	 * @return
	 */
	public DtoMantenimiento deleteMaintenance(DtoMantenimiento mantenimiento,DataSourceConnector source);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param source
	 * @return
	 */
	public ArrayList<DtoMantenimiento> findMaintenance(DtoMantenimiento mantenimiento,DataSourceConnector source,PageData pageData);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param source
	 * @return
	 */
	public ArrayList<DtoMantenimiento> findMaintenanceMonthScheduled(DtoMantenimiento mantenimiento,DataSourceConnector source);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param source
	 * @return
	 */
	public ArrayList<DtoMantenimiento> findMaintenanceMonthExpired(DtoMantenimiento mantenimiento,DataSourceConnector source);
	
}
