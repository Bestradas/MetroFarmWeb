package co.com.farmatech.metrofarm.processor;

import co.com.farmatech.metrofarm.bimanager.reports.MgrReportImpl;
import co.com.farmatech.metrofarm.bimanager.reports.MgrReportService;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.operations.Operations;

import com.co.farmatech.metrofarm.dto.DtoReport;

public class ReportsServices implements ProcessService  {
	
	MgrReportService mgrReport=new MgrReportImpl();

	@Override
	public Object doProcess(ObjectSend send) {
		// TODO Auto-generated method stub
		switch (send.getOperation()) {
		//CREATE_PROFILE
		case Operations.REPORT_CALIBRATION_FOR_EQUIPMENT:
			return mgrReport.createCalibrationForEquipment((DtoReport)send.getObj());

			//UPDATE_PROFILE	
		case Operations.REPORT_CALIBRATION_FOR_MONTH:
			return mgrReport.createCalibrationForMonth((DtoReport)send.getObj());

			//FIND_PROFILE	
		case Operations.INDICATOR_CALIBRATION:
			return mgrReport.indicatorCalibration((DtoReport)send.getObj());
			
		case Operations.INDICATOR_CALIFICATION:
			return mgrReport.indicatorCalification((DtoReport)send.getObj());
			
		case Operations.INDICATOR_MAINTENANCE_GENERAL:
			return mgrReport.indicatorMaintenanceGeneral((DtoReport)send.getObj());
		
		case Operations.MAINTENANCE_FOR_EQUIPMENT:
			return mgrReport.maintenanceEquipment((DtoReport)send.getObj());
		
		case Operations.MAINTENANCE_FOR_MONTH:
			return mgrReport.maintenanceGeneralMonth((DtoReport)send.getObj());
			
		case Operations.MAINTENANCE_FOR_EQUIPMENT_GENERAL:
			return mgrReport.maintenanceMonth((DtoReport)send.getObj());
			
		case Operations.MAINTENANCE_FOR_MONTH_GENERAL:
			return mgrReport.maintenanceMonthGeneral((DtoReport)send.getObj());

		default:
			break;
		}
		return send;
	}

}
