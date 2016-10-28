package co.com.farmatech.metrofarm.bimanager.profile;

import java.util.ArrayList;

import co.com.farmatech.metrofarm.dao.profile.ProfileDaoImpl;
import co.com.farmatech.metrofarm.dao.profile.ProfileDaoService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.metrofarm.exception.JankerExceptionEnum;

import com.co.farmatech.metrofarm.dto.DtoPerfil;
import com.co.farmatech.metrofarm.dto.PageData;

public class MgrProfileImpl implements MgrProfileService{
	
	ProfileDaoService profileDao=new ProfileDaoImpl();
	
	@Override
	public DtoPerfil createProfile(DtoPerfil perfil, DataSourceConnector source) {
		// TODO Auto-generated method stub
			return profileDao.createProfile(perfil, source.getConexion());
	}
	
	@Override
	public ArrayList<DtoPerfil> findProfiles(DtoPerfil perfil,
			DataSourceConnector source,PageData pageData) {
		// TODO Auto-generated method stub
		return profileDao.findProfiles(perfil, source.getConexion(),pageData);
	}
	
	@Override
	public DtoPerfil updateProfile(DtoPerfil perfil, DataSourceConnector source) {
		// TODO Auto-generated method stub
		return profileDao.updateProfile(perfil, source.getConexion());
	}

}