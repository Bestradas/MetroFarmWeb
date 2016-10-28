package co.com.farmatech.metrofarm.bimanager.maintenance;

import java.util.ArrayList;

import co.com.farmatech.metrofarm.dao.calibration.CalibrationDaoImpl;
import co.com.farmatech.metrofarm.dao.calibration.CalibrationDaoService;
import co.com.farmatech.metrofarm.dao.maintenance.MaintenanceDaoImpl;
import co.com.farmatech.metrofarm.dao.maintenance.MaintenanceDaoService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.metrofarm.exception.JankerExceptionEnum;

import com.co.farmatech.metrofarm.dto.DtoMantenimiento;
import com.co.farmatech.metrofarm.dto.PageData;

public class MgrMaintenanceImpl implements MgrMaintenanceService{
	
	MaintenanceDaoService maintenanceDao=new MaintenanceDaoImpl();
	
	@Override
	public DtoMantenimiento createFirstMaintenance(
			DtoMantenimiento mantenimiento, DataSourceConnector source) {
		// TODO Auto-generated method stub
		if(!maintenanceDao.EquipmentMaintenance(mantenimiento.getEquipo(), source.getConexion())){
			return maintenanceDao.createFirstMaintenance(mantenimiento, source.getConexion());
		}else{
			throw new JankinsMarshallException(JankerExceptionEnum.E_60000.getDescription(),JankerExceptionEnum.E_60000.getValue());
		}
	}

	@Override
	public DtoMantenimiento createMaintenance(DtoMantenimiento mantenimiento,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		return maintenanceDao.createMaintenance(mantenimiento, source.getConexion());
	}

	@Override
	public DtoMantenimiento updateMaintenance(DtoMantenimiento mantenimiento,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		return maintenanceDao.updateMaintenance(mantenimiento, source.getConexion());
	}

	@Override
	public DtoMantenimiento deleteMaintenance(DtoMantenimiento mantenimiento,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		return maintenanceDao.deleteMaintenance(mantenimiento, source.getConexion());
	}

	@Override
	public ArrayList<DtoMantenimiento> findMaintenance(
			DtoMantenimiento mantenimiento, DataSourceConnector source,PageData pageData) {
		// TODO Auto-generated method stub
		return maintenanceDao.findMaintenance(mantenimiento, source.getConexion(),pageData);
	}

	@Override
	public ArrayList<DtoMantenimiento> findMaintenanceMonthScheduled(
			DtoMantenimiento mantenimiento, DataSourceConnector source) {
		// TODO Auto-generated method stub
		return maintenanceDao.findMaintenanceMonthScheduled(mantenimiento, source.getConexion());
	}

	@Override
	public ArrayList<DtoMantenimiento> findMaintenanceMonthExpired(
			DtoMantenimiento mantenimiento, DataSourceConnector source) {
		// TODO Auto-generated method stub
		return maintenanceDao.findMaintenanceMonthExpired(mantenimiento, source.getConexion());
	}

}