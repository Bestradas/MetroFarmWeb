package co.com.farmatech.metrofarm.dao.calibration;

import java.sql.Connection;
import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoCalibracion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProveedor;
import com.co.farmatech.metrofarm.dto.PageData;


public interface CalibrationDaoService {
	
	/**
	 * 
	 * @param calibration
	 * @param con
	 * @return
	 */
	public DtoCalibracion createFirstCalibration(DtoCalibracion calibration, Connection con);
	
	/**
	 * 
	 * @param calibration
	 * @param con
	 * @return
	 */
	public DtoCalibracion createCalibration(DtoCalibracion calibration, Connection con);
	
	/**
	 * 
	 * @param calibration
	 * @param con
	 * @return
	 */
	public DtoCalibracion deleteCalibration(DtoCalibracion calibration, Connection con);
	
	/**
	 * 
	 * @param calibration
	 * @param con
	 * @return
	 */
	public DtoCalibracion updateCalibration(DtoCalibracion calibration, Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public boolean EquipmentCalibration(DtoEquipo equipo, Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public ArrayList<DtoCalibracion> findCalibration(DtoEquipo equipo, Connection con,PageData pageData);
	
	/**
	 * 
	 * @param calibracion
	 * @param con
	 * @return
	 */
	public ArrayList<DtoCalibracion> findCalibration(DtoCalibracion calibracion, Connection con,PageData pageData);
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public ArrayList<DtoCalibracion> findCalibrationMonthScheduled(DtoEquipo equipo, Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public ArrayList<DtoCalibracion> findCalibrationMonthExpired(DtoEquipo equipo, Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public ArrayList<DtoProveedor> getProviders(DtoProveedor equipo, Connection con);
	

}
