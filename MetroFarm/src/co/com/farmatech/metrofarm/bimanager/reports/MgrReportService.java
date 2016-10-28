package co.com.farmatech.metrofarm.bimanager.reports;

import com.co.farmatech.metrofarm.dto.DtoReport;

public interface MgrReportService  {

	public DtoReport createCalibrationForEquipment(DtoReport reporte);
	
	public DtoReport createCalibrationForMonth(DtoReport reporte);
	
	public DtoReport indicatorCalibration(DtoReport reporte);
	
	public DtoReport indicatorCalification(DtoReport reporte);
	
	public DtoReport indicatorMaintenanceGeneral(DtoReport reporte);
	
	public DtoReport maintenanceEquipment(DtoReport reporte);
	
	public DtoReport maintenanceGeneralMonth(DtoReport reporte);
	
	public DtoReport maintenanceMonth(DtoReport reporte);
	
	public DtoReport maintenanceMonthGeneral(DtoReport reporte);
	
}
