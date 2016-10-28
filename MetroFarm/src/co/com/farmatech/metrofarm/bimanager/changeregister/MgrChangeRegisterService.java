package co.com.farmatech.metrofarm.bimanager.changeregister;

import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoRegistroCambios;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;



public interface MgrChangeRegisterService {

	/**
	 * 
	 * @param registroCambios
	 * @param source
	 * @return
	 */
	public DtoRegistroCambios createChangeRegister(DtoRegistroCambios registroCambios,DataSourceConnector source);
	
	/**
	 * 
	 * @param registroCambios
	 * @param source
	 * @return
	 */
	public ArrayList<DtoRegistroCambios> listChangeRegister(DtoRegistroCambios registroCambios,DataSourceConnector source);
	
}
