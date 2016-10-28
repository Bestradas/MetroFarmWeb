package co.com.farmatech.metrofarm.dao.calification;

import java.sql.Connection;
import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoCalibracion;
import com.co.farmatech.metrofarm.dto.DtoCalificacion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProgramCalificacion;

public interface CalificationDaoService {
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public ArrayList<DtoCalificacion> findCalification(DtoEquipo equipo, Connection con);
	
	/**
	 * 
	 * @param calification
	 * @param con
	 * @return
	 */
	public DtoCalificacion createFirstCalification(DtoCalificacion calification, Connection con);
	
	/**
	 * 
	 * @param calification
	 * @param con
	 * @return
	 */
	public DtoCalificacion createCalification(DtoCalificacion calification, Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public boolean EquipmentCalification(DtoEquipo equipo, Connection con);
	
	/**
	 * 
	 * @param calification
	 * @param con
	 * @return
	 */
	public boolean programCalification(DtoProgramCalificacion calification, Connection con);
	
	/**
	 * 
	 * @param calification
	 * @param con
	 * @return
	 */
	public void updateProgramming(DtoProgramCalificacion calification,Connection con);
	
	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public ArrayList<DtoProgramCalificacion> findCalificationMonthScheduled(DtoEquipo equipo, Connection con);

	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public ArrayList<DtoProgramCalificacion> findCalificationMonthExpired(DtoEquipo equipo, Connection con);

	/**
	 * 
	 * @param equipo
	 * @param con
	 * @return
	 */
	public ArrayList<DtoProgramCalificacion> findCalificationProgramming(DtoEquipo equipo, Connection con);
	
	
}
