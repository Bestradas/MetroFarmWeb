package co.com.farmatech.metrofarm.bimanager.calification;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import co.com.farmatech.metrofarm.dao.calification.CalificationDaoImpl;
import co.com.farmatech.metrofarm.dao.calification.CalificationDaoService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.global.GlobalUtils;
import co.jankins.psf.common.metrofarm.exception.JankerExceptionEnum;

import com.co.farmatech.metrofarm.dto.DtoCalificacion;
import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoProgramCalificacion;

public class MgrCalificationImpl implements MgrCalificationService{

	CalificationDaoService calificationDao=new CalificationDaoImpl();
	public File NOAPLICA=new File(getClass().getClassLoader().getResource("co/jankins/files/NO.pdf").getFile());

	@Override
	public DtoCalificacion createFirstCalification(DtoCalificacion calificacion,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		DtoCalificacion dtoCalificacion=null;
		if(!calificationDao.EquipmentCalification(calificacion.getEquipo(), source.getConexion())){
			calificationDao.createFirstCalification(calificacion, source.getConexion());
			if(calificacion.getProgramCalif()!=null){
				for (DtoProgramCalificacion califProg : calificacion.getProgramCalif()) {
					calificationDao.programCalification(califProg, source.getConexion());
				}
			}
			return calificacion;
		}else{
			throw new JankinsMarshallException(JankerExceptionEnum.E_70000.getDescription(),JankerExceptionEnum.E_70000.getValue());
		}
	}

	@Override
	public DtoCalificacion creatCalificacion(DtoCalificacion calificacion,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		if(!calificationDao.EquipmentCalification(calificacion.getEquipo(), source.getConexion())){
			calificationDao.createFirstCalification(calificacion, source.getConexion());
			if(calificacion.getProgramCalif()!=null){
				for (DtoProgramCalificacion califProg : calificacion.getProgramCalif()) {
					calificationDao.programCalification(califProg, source.getConexion());
				}
			}
			return calificacion;
		}else{
			calificationDao.createCalification(calificacion, source.getConexion());
			return calificacion;
		}
	}

	@Override
	public ArrayList<DtoCalificacion> findCalifications(DtoEquipo equipo,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calificationDao.findCalification(equipo, source.getConexion());
	}

	@Override
	public ArrayList<DtoProgramCalificacion> findCalificationsMonthScheduled(
			DtoEquipo equipo, DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calificationDao.findCalificationMonthScheduled(equipo, source.getConexion());
	}

	@Override
	public ArrayList<DtoProgramCalificacion> findCalificationsMonthExpired(
			DtoEquipo equipo, DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calificationDao.findCalificationMonthExpired(equipo, source.getConexion());
	}

	@Override
	public ArrayList<DtoProgramCalificacion> findCalificationsProgramming(
			DtoEquipo equipo, DataSourceConnector source) {
		// TODO Auto-generated method stub
		return calificationDao.findCalificationProgramming(equipo, source.getConexion());

	}

}
