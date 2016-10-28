package co.com.farmatech.metrofarm.processor;

import java.util.ArrayList;

import co.com.farmatech.metrofarm.bimanager.calification.MgrCalificationImpl;
import co.com.farmatech.metrofarm.bimanager.calification.MgrCalificationService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.operations.Operations;

import com.co.farmatech.metrofarm.dto.DtoCalificacion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProgramCalificacion;

public class CalificationService implements ProcessService{
	
	MgrCalificationService mgrCalification=new MgrCalificationImpl();
	
	@Override
	public Object doProcess(ObjectSend send) {
		// TODO Auto-generated method stub
		switch (send.getOperation()) {
		//FIND_EQUIPMENT
		case Operations.CREATE_FIRST_CALIFICATION:
			return createFirstCalification((DtoCalificacion)send.getObj());
			
		case Operations.CREATE_CALIFICATION:
			return creatCalificacion((DtoCalificacion)send.getObj());

		case Operations.FIND_CALIFICATION:
			return findCalifications((DtoEquipo)send.getObj());
			
		case Operations.FIND_CALIFICATION_MONTH_SCHEDULED:
			return findCalificationsMonthScheduled((DtoEquipo)send.getObj());
		
		case Operations.FIND_CALIFICATION_MONTH_EXPIRED:
			return findCalificationsMonthExpired((DtoEquipo)send.getObj());
		
		case Operations.FIND_CALIFICATION_PROGRAMMING:
			return findCalificationsProgramming((DtoEquipo)send.getObj());
			
		default:
			break;
		}
		return send.getObj()!=null?send.getObj():send.getRecords();
	}
	
	public DtoCalificacion createFirstCalification(DtoCalificacion calificacion){
		DtoCalificacion califitionResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			califitionResponse=mgrCalification.createFirstCalification(calificacion, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return califitionResponse;
	}
	
	public DtoCalificacion creatCalificacion(DtoCalificacion calificacion){
		DtoCalificacion califitionResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			califitionResponse=mgrCalification.creatCalificacion(calificacion, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return califitionResponse;
	}
	
	public ArrayList<DtoCalificacion> findCalifications(DtoEquipo equipo){
		ArrayList<DtoCalificacion> califitionResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			califitionResponse=mgrCalification.findCalifications(equipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return califitionResponse;
	}
	
	public ArrayList<DtoProgramCalificacion> findCalificationsMonthScheduled(DtoEquipo equipo){
		ArrayList<DtoProgramCalificacion> califitionResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			califitionResponse=mgrCalification.findCalificationsMonthScheduled(equipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return califitionResponse;
	}
	
	public ArrayList<DtoProgramCalificacion> findCalificationsMonthExpired(DtoEquipo equipo){
		ArrayList<DtoProgramCalificacion> califitionResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			califitionResponse=mgrCalification.findCalificationsMonthExpired(equipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return califitionResponse;
	}

	public ArrayList<DtoProgramCalificacion> findCalificationsProgramming(DtoEquipo equipo){
		ArrayList<DtoProgramCalificacion> califitionResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			califitionResponse=mgrCalification.findCalificationsProgramming(equipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return califitionResponse;
	}
	

}
