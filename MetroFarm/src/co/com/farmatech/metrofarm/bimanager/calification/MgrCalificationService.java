package co.com.farmatech.metrofarm.bimanager.calification;

import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoCalificacion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProgramCalificacion;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;


public interface MgrCalificationService {
	
	/**
	 * 
	 * @param calificacion
	 * @param source
	 * @return
	 */
	public DtoCalificacion createFirstCalification(DtoCalificacion calificacion,DataSourceConnector source);
	
	/**
	 * 
	 * @param calificacion
	 * @param source
	 * @return
	 */
	public DtoCalificacion creatCalificacion(DtoCalificacion calificacion,DataSourceConnector source);
	
	/**
	 * 
	 * @param equipo
	 * @param source
	 * @return
	 */
	public ArrayList<DtoCalificacion> findCalifications(DtoEquipo equipo,DataSourceConnector source);
	
	/**
	 * 
	 * @param equipo
	 * @param source
	 * @return
	 */
	public ArrayList<DtoProgramCalificacion> findCalificationsMonthScheduled(DtoEquipo equipo,DataSourceConnector source);

	/**
	 * 
	 * @param equipo
	 * @param source
	 * @return
	 */
	public ArrayList<DtoProgramCalificacion> findCalificationsMonthExpired(DtoEquipo equipo,DataSourceConnector source);
	
	
	/**
	 * 
	 * @param equipo
	 * @param source
	 * @return
	 */
	public ArrayList<DtoProgramCalificacion> findCalificationsProgramming(DtoEquipo equipo,DataSourceConnector source);
}
