package co.com.farmatech.metrofarm.bimanager.changeregister;

import java.util.ArrayList;

import co.com.farmatech.metrofarm.dao.changeregister.ChangeRegisterDaoImpl;
import co.com.farmatech.metrofarm.dao.changeregister.ChangeRegisterDaoService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.metrofarm.exception.JankerExceptionEnum;

import com.co.farmatech.metrofarm.dto.DtoRegistroCambios;

public class MgrChangeRegisterImpl implements MgrChangeRegisterService{

	ChangeRegisterDaoService changeService=new ChangeRegisterDaoImpl();

	@Override
	public DtoRegistroCambios createChangeRegister(
			DtoRegistroCambios registroCambio, DataSourceConnector source) {
		// TODO Auto-generated method stub
		DtoRegistroCambios changeFind=changeService.findChangeRegister(registroCambio, source.getConexion());
		if(changeFind!=null){
			throw new JankinsMarshallException(JankerExceptionEnum.E_40000.getDescription(),JankerExceptionEnum.E_40000.getValue());
		}else{
			return changeService.createChangeRegister(registroCambio, source.getConexion());
		}
	}

	@Override
	public ArrayList<DtoRegistroCambios> listChangeRegister(
			DtoRegistroCambios registroCambios, DataSourceConnector source) {
		// TODO Auto-generated method stub
		return changeService.listChangeRegister(registroCambios, source.getConexion());
	}

}
