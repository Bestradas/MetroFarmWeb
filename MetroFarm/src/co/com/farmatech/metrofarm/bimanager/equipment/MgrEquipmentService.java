package co.com.farmatech.metrofarm.bimanager.equipment;

import java.util.ArrayList;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;

import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.PageData;

public interface MgrEquipmentService {
	
	/**
	 * 
	 * @param equipo
	 * @return
	 */
	public ArrayList<DtoEquipo> findEquipment(DtoEquipo equipo,DataSourceConnector source,PageData pageData);
	
	/**
	 * 
	 * @param equipo
	 * @return
	 */
	public DtoEquipo findEquipmentExist(DtoEquipo equipo,DataSourceConnector source);
	
	/**
	 * 
	 * @param equipo
	 * @return
	 */
	public DtoEquipo createEquipment(DtoEquipo equipo,DataSourceConnector source);
	
	/**
	 * 
	 * @param equipo
	 * @return
	 */
	public DtoEquipo updateEquipment(DtoEquipo equipo,DataSourceConnector source);

}
