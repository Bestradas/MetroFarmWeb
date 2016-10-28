package co.com.farmatech.metrofarm.bimanager.profile;

import java.util.ArrayList;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;

import com.co.farmatech.metrofarm.dto.DtoPerfil;
import com.co.farmatech.metrofarm.dto.PageData;

public interface MgrProfileService {
	
	/**
	 * 
	 * @param perfil
	 * @param source
	 * @return
	 */
	public DtoPerfil createProfile(DtoPerfil perfil,DataSourceConnector source);
	
	/**
	 * 
	 * @param perfil
	 * @param source
	 * @return
	 */
	public DtoPerfil updateProfile(DtoPerfil perfil,DataSourceConnector source);
	
	/**
	 * 
	 * @param perfil
	 * @param source
	 * @return
	 */
	public ArrayList<DtoPerfil> findProfiles(DtoPerfil perfil,DataSourceConnector source,PageData pageData);

}
