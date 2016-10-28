package co.com.farmatech.metrofarm.dao.changeregister;

import java.sql.Connection;
import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoRegistroCambios;


public interface ChangeRegisterDaoService {
	
	/**
	 * 
	 * @param registroCambio
	 * @param con
	 * @return
	 */
	public DtoRegistroCambios findChangeRegister(DtoRegistroCambios registroCambio,Connection con);
	
	/**
	 * 
	 * @param registroCambio
	 * @param con
	 * @return
	 */
	public DtoRegistroCambios createChangeRegister(DtoRegistroCambios registroCambio,Connection con);

	/**
	 * 
	 * @param registroCambio
	 * @param con
	 * @return
	 */
	public ArrayList<DtoRegistroCambios> listChangeRegister(DtoRegistroCambios registroCambio,Connection con);

	
}
