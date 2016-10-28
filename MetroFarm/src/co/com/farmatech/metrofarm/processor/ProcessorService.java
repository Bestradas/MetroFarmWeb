package co.com.farmatech.metrofarm.processor;

import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.services.Services;

public class ProcessorService implements ProcessService{

	@Override
	public Object doProcess(ObjectSend send) {
		// TODO Auto-generated method stub
		switch (send.getService()) {
		case Services.USER_SERVICE:
			ProcessService proccesUsers=new UserServices();
			return proccesUsers.doProcess(send);
			
		case Services.PROFILE_SERVICE:
			ProcessService proccesProfiles=new ProfileServices();
			return proccesProfiles.doProcess(send);
		
		case Services.EMAIL_SERVICE:
			ProcessService proccessEmail=new EmailServices();
			return proccessEmail.doProcess(send);
		
		case Services.EQUIPMENT_SERVICE:
			ProcessService processEquipment=new EquipmentServices();
			return processEquipment.doProcess(send);
			
		case Services.CHANGE_REGISTER_SERVICE:
			ProcessService processChangeRegister=new ChangeRegisterService();
			return processChangeRegister.doProcess(send);
		
		case Services.CALIBRATION_SERVICE:
			ProcessService processCalibration=new CalibrationService();
			return processCalibration.doProcess(send);
			
		case Services.QUALIFICATION_SERVICE:
			ProcessService processCalification=new CalificationService();
			return processCalification.doProcess(send);
		
		case Services.MAINTENANCE_GENERAL_SERVICE:
			ProcessService processMaintenanceGeneral=new MaintenanceGeneralService();
			return processMaintenanceGeneral.doProcess(send);
		
		case Services.MAINTENANCE_SERVICE:
			ProcessService processMaintenance=new MaintenanceGeneralService();
			return processMaintenance.doProcess(send);
			
		case Services.NOTIFICATION_SERVICE:
			ProcessService processNotifications=new NotificationServices();
			return processNotifications.doProcess(send);
		
		case Services.REPORT_SERVICE:
			ProcessService processReports=new ReportsServices();
			return processReports.doProcess(send);
			
		default:
			break;
		}
		throw new JankinsMarshallException("No se ha encontrado el servicio especificado");
	}

}