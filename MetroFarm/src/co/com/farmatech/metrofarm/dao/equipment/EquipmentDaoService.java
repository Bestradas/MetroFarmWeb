package co.com.farmatech.metrofarm.dao.equipment;

import java.sql.Connection;
import java.util.ArrayList;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;

import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.PageData;

public interface EquipmentDaoService {

	/**
	 * 
	 * @param equipo
	 * @return
	 */
	public ArrayList<DtoEquipo> findEquipment(DtoEquipo equipo,Connection con,PageData pageData);
	
	/**
	 * 
	 * @param equipo
	 * @return
	 */
	public DtoEquipo findEquipmentExist(DtoEquipo equipo,Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @return
	 */
	public DtoEquipo createEquipment(DtoEquipo equipo,Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @return
	 */
	public DtoEquipo updateEquipment(DtoEquipo equipo,Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public boolean validateMaintanencesRegister(DtoEquipo equipo,Connection con); 
	
}