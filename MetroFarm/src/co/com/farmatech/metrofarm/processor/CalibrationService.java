package co.com.farmatech.metrofarm.processor;

import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoCalibracion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProveedor;
import com.co.farmatech.metrofarm.dto.PageData;

import co.com.farmatech.metrofarm.bimanager.calibration.MgrCalibrationImpl;
import co.com.farmatech.metrofarm.bimanager.calibration.MgrCalibrationService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.operations.Operations;

public class CalibrationService implements ProcessService{

	MgrCalibrationService mgrCalibration=new MgrCalibrationImpl();
	
	@Override
	public Object doProcess(ObjectSend send) {
		// TODO Auto-generated method stub
		switch (send.getOperation()) {
		//FIND_EQUIPMENT
		case Operations.CREATE_FIRST_CALIBRATION:
			return createFirstCalibration((DtoCalibracion)send.getObj());
			
		case Operations.FIND_CALIBRATION:
			if(send.getObj() instanceof DtoCalibracion){
				return findCalibrations((DtoCalibracion)send.getObj(),send.getPageData());
			}else{
				return findCalibrations((DtoEquipo)send.getObj(),send.getPageData());
			}
			
		
		case Operations.CREATE_CALIBRATION:
			return createCalibrations((DtoCalibracion)send.getObj());	
			
		case Operations.DELETE_CALIBRATION:
			return deleteCalibrations((DtoCalibracion)send.getObj());	
		
		case Operations.UPDATE_CALIBRATION:
			return updateCalibrations((DtoCalibracion)send.getObj());
			
		case Operations.FIND_CALIBRATION_MONTH_SCHEDULED:
			return findCalibrationsMonthScheduled((DtoEquipo)send.getObj());
		
		case Operations.FIND_CALIBRATION_MONTH_EXPIRED:
			return findCalibrationsMonthExpired((DtoEquipo)send.getObj());
			
		case Operations.GET_PROVIDERS:
			return getProviders((DtoProveedor)send.getObj());
			
		default:
			break;
		}
		return send.getObj()!=null?send.getObj():send.getRecords();
	}
	
	public DtoCalibracion createFirstCalibration(DtoCalibracion calibracion){
		DtoCalibracion calibrationResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			calibrationResponse=mgrCalibration.createFirstCalibration(calibracion, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
		}

		return calibrationResponse;
	}
	
	public ArrayList<DtoCalibracion> findCalibrations(DtoEquipo equipo,PageData pageData){
		ArrayList<DtoCalibracion> calibrationResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			calibrationResponse=mgrCalibration.findCalibrations(equipo, datasource,pageData);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
		}

		return calibrationResponse;
	}
	
	public ArrayList<DtoCalibracion> findCalibrations(DtoCalibracion calibracion,PageData pageData){
		ArrayList<DtoCalibracion> calibrationResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			calibrationResponse=mgrCalibration.findCalibrations(calibracion, datasource,pageData);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
		}

		return calibrationResponse;
	}
	
	public ArrayList<DtoCalibracion> findCalibrationsMonthScheduled(DtoEquipo equipo){
		ArrayList<DtoCalibracion> calibrationResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			calibrationResponse=mgrCalibration.findCalibrationsMonthScheduled(equipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
		}

		return calibrationResponse;
	}
	
	public ArrayList<DtoCalibracion> findCalibrationsMonthExpired(DtoEquipo equipo){
		ArrayList<DtoCalibracion> calibrationResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			calibrationResponse=mgrCalibration.findCalibrationsMonthExpired(equipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
		}

		return calibrationResponse;
	}
	
	public DtoCalibracion createCalibrations(DtoCalibracion calibracion){
		DtoCalibracion calibrationResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			calibrationResponse=mgrCalibration.createCalibration(calibracion, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
		}

		return calibrationResponse;
	}
	
	public DtoCalibracion deleteCalibrations(DtoCalibracion calibracion){
		DtoCalibracion calibrationResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			calibrationResponse=mgrCalibration.deleteCalibration(calibracion, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
		}

		return calibrationResponse;
	}
	
	public DtoCalibracion updateCalibrations(DtoCalibracion calibracion){
		DtoCalibracion calibrationResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			calibrationResponse=mgrCalibration.updateCalibration(calibracion, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
		}

		return calibrationResponse;
	}
	
	public ArrayList<DtoProveedor> getProviders(DtoProveedor proveedor){
		ArrayList<DtoProveedor> providersResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			providersResponse=mgrCalibration.getProviders(proveedor, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
		}

		return providersResponse;
	}
	
}
