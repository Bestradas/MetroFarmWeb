package co.com.farmatech.metrofarm.processor;

import java.util.ArrayList;

import co.com.farmatech.metrofarm.bimanager.maintenance.MgrMaintenanceImpl;
import co.com.farmatech.metrofarm.bimanager.maintenance.MgrMaintenanceService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.operations.Operations;

import com.co.farmatech.metrofarm.dto.DtoMantenimiento;
import com.co.farmatech.metrofarm.dto.PageData;

public class MaintenanceGeneralService implements ProcessService{

	MgrMaintenanceService mgrMaintenance=new MgrMaintenanceImpl();
	
	@Override
	public Object doProcess(ObjectSend send) {
		// TODO Auto-generated method stub
		switch (send.getOperation()) {
		//FIND_EQUIPMENT
		case Operations.CREATE_FIRST_MAINTENANCE:
			return createFirstMaintenance((DtoMantenimiento)send.getObj());

		case Operations.CREATE_MAINTENANCE:
			return createMaintenance((DtoMantenimiento)send.getObj());

		case Operations.UPDATE_MAINTENANCE:
			return updateMaintenance((DtoMantenimiento)send.getObj());
			
		case Operations.DELETE_MAINTENANCE:
			return deleteMaintenance((DtoMantenimiento)send.getObj());
			
		case Operations.FIND_MAINTENANCE:
			return findMaintenance((DtoMantenimiento)send.getObj(),send.getPageData());
			
		case Operations.FIND_MAINTENANCE_MONTH_SCHEDULED:
			return findMaintenanceMonthScheduled((DtoMantenimiento)send.getObj());
			
		case Operations.FIND_MAINTENANCE_MONTH_EXPIRED:
			return findMaintenanceMonthExpired((DtoMantenimiento)send.getObj());
			
		default:
			break;
		}
		return send.getObj()!=null?send.getObj():send.getRecords();
	}
	
	
	public DtoMantenimiento createFirstMaintenance(DtoMantenimiento mantenimiento){
		DtoMantenimiento maintenanceResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			maintenanceResponse=mgrMaintenance.createFirstMaintenance(mantenimiento, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return maintenanceResponse;
	}
	
	public DtoMantenimiento createMaintenance(DtoMantenimiento mantenimiento){
		DtoMantenimiento maintenanceResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			maintenanceResponse=mgrMaintenance.createMaintenance(mantenimiento, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return maintenanceResponse;
	}
	
	public DtoMantenimiento updateMaintenance(DtoMantenimiento mantenimiento){
		DtoMantenimiento maintenanceResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			maintenanceResponse=mgrMaintenance.updateMaintenance(mantenimiento, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return maintenanceResponse;
	}
	
	public DtoMantenimiento deleteMaintenance(DtoMantenimiento mantenimiento){
		DtoMantenimiento maintenanceResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			maintenanceResponse=mgrMaintenance.deleteMaintenance(mantenimiento, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return maintenanceResponse;
	}
	
	public ArrayList<DtoMantenimiento> findMaintenance(DtoMantenimiento mantenimiento,PageData pageData){
		ArrayList<DtoMantenimiento> maintenanceResponse = new ArrayList<DtoMantenimiento>();
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			maintenanceResponse=mgrMaintenance.findMaintenance(mantenimiento, datasource,pageData);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return maintenanceResponse;
	}
	
	public ArrayList<DtoMantenimiento> findMaintenanceMonthScheduled(DtoMantenimiento mantenimiento){
		ArrayList<DtoMantenimiento> maintenanceResponse = new ArrayList<DtoMantenimiento>();
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			maintenanceResponse=mgrMaintenance.findMaintenanceMonthScheduled(mantenimiento, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return maintenanceResponse;
	}
	
	public ArrayList<DtoMantenimiento> findMaintenanceMonthExpired(DtoMantenimiento mantenimiento){
		ArrayList<DtoMantenimiento> maintenanceResponse = new ArrayList<DtoMantenimiento>();
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			maintenanceResponse=mgrMaintenance.findMaintenanceMonthExpired(mantenimiento, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return maintenanceResponse;
	}
	

}
