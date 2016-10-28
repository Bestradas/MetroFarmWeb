package co.com.farmatech.metrofarm.dao.maintenance;

import java.sql.Connection;



import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoMantenimiento;
import com.co.farmatech.metrofarm.dto.PageData;

public interface MaintenanceDaoService {
	
	/**
	 * 
	 * @param mantenimiento
	 * @param con
	 * @return
	 */
	public DtoMantenimiento createFirstMaintenance(DtoMantenimiento mantenimiento, Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public boolean EquipmentMaintenance(DtoEquipo equipo, Connection con);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param con
	 * @return
	 */
	public DtoMantenimiento createMaintenance(DtoMantenimiento mantenimiento, Connection con);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param con
	 * @return
	 */
	public DtoMantenimiento updateMaintenance(DtoMantenimiento mantenimiento, Connection con);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param con
	 * @return
	 */
	public DtoMantenimiento deleteMaintenance(DtoMantenimiento mantenimiento, Connection con);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param con
	 * @return
	 */
	public ArrayList<DtoMantenimiento> findMaintenance(DtoMantenimiento mantenimiento, Connection con,PageData pageData);
	
	/**
	 * 
	 * @param mantenimiento
	 * @param con
	 * @return
	 */
	public ArrayList<DtoMantenimiento> findMaintenanceMonthScheduled(DtoMantenimiento mantenimiento, Connection con);

	/**
	 * 
	 * @param mantenimiento
	 * @param con
	 * @return
	 */
	public ArrayList<DtoMantenimiento> findMaintenanceMonthExpired(DtoMantenimiento mantenimiento, Connection con);

}
