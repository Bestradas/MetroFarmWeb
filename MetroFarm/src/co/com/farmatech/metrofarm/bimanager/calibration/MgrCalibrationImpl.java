package co.com.farmatech.metrofarm.bimanager.calibration;

import java.util.ArrayList;

import co.com.farmatech.metrofarm.dao.calibration.CalibrationDaoImpl;
import co.com.farmatech.metrofarm.dao.calibration.CalibrationDaoService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.metrofarm.exception.JankerExceptionEnum;

import com.co.farmatech.metrofarm.dto.DtoCalibracion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProveedor;
import com.co.farmatech.metrofarm.dto.PageData;

public class MgrCalibrationImpl implements MgrCalibrationService{
	
	CalibrationDaoService calibrationDao=new CalibrationDaoImpl();
	
	@Override
	public DtoCalibracion createFirstCalibration(DtoCalibracion calibracion,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		if(!calibrationDao.EquipmentCalibration(calibracion.getEquipo(), source.getConexion())){
			return calibrationDao.createFirstCalibration(calibracion, source.getConexion());
		}else{
			throw new JankinsMarshallException(JankerExceptionEnum.E_50000.getDescription(),JankerExceptionEnum.E_50000.getValue());
		}
		
	}
	
	@Override
	public ArrayList<DtoCalibracion> findCalibrations(DtoEquipo equipo,DataSourceConnector source,PageData pageData) {
		// TODO Auto-generated method stub
		
			return calibrationDao.findCalibration(equipo, source.getConexion(),pageData);
		
		
	}

	@Override
	public DtoCalibracion createCalibration(DtoCalibracion calibracion,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calibrationDao.createCalibration(calibracion, source.getConexion());
	}

	@Override
	public DtoCalibracion updateCalibration(DtoCalibracion calibracion,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calibrationDao.updateCalibration(calibracion, source.getConexion());
	}

	@Override
	public ArrayList<DtoCalibracion> findCalibrationsMonthScheduled(
			DtoEquipo equipo, DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calibrationDao.findCalibrationMonthScheduled(equipo, source.getConexion());
	}

	@Override
	public ArrayList<DtoCalibracion> findCalibrationsMonthExpired(
			DtoEquipo equipo, DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calibrationDao.findCalibrationMonthExpired(equipo, source.getConexion());
	}

	@Override
	public ArrayList<DtoProveedor> getProviders(DtoProveedor proveedor,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calibrationDao.getProviders(proveedor, source.getConexion());
	}

	@Override
	public ArrayList<DtoCalibracion> findCalibrations(
			DtoCalibracion calibracion, DataSourceConnector source,PageData pageData) {
		// TODO Auto-generated method stub
		return calibrationDao.findCalibration(calibracion, source.getConexion(),pageData);
	}

	@Override
	public DtoCalibracion deleteCalibration(DtoCalibracion calibracion,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calibrationDao.deleteCalibration(calibracion, source.getConexion());
	}
	
}
