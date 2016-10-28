package co.com.farmatech.metrofarm.processor;

import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoPerfil;
import com.co.farmatech.metrofarm.dto.DtoUsuario;
import com.co.farmatech.metrofarm.dto.PageData;

import co.com.farmatech.metrofarm.bimanager.profile.MgrProfileImpl;
import co.com.farmatech.metrofarm.bimanager.profile.MgrProfileService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.operations.Operations;

public class ProfileServices implements ProcessService{

	MgrProfileService mgrProfile=new MgrProfileImpl();
	
	@Override
	public Object doProcess(ObjectSend send) {
		// TODO Auto-generated method stub
		switch (send.getOperation()) {
		//CREATE_PROFILE
		case Operations.CREATE_PROFILE:
			return createProfile((DtoPerfil)send.getObj());

			//UPDATE_PROFILE	
		case Operations.UPDATE_PROFILE:
			return updateProfile((DtoPerfil)(DtoPerfil)send.getObj());

			//FIND_PROFILE	
		case Operations.FIND_PROFILE:
			return findProfile((DtoPerfil)send.getObj(),send.getPageData());


		default:
			break;
		}
		return send;
	}
	
	public DtoPerfil createProfile(DtoPerfil perfil){
		DtoPerfil profileResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			profileResponse=mgrProfile.createProfile(perfil, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return profileResponse;
	}
	
	public DtoPerfil updateProfile(DtoPerfil perfil){
		DtoPerfil profileResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			profileResponse=mgrProfile.updateProfile(perfil, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return profileResponse;
	}
	
	public ArrayList<DtoPerfil> findProfile(DtoPerfil perfil,PageData pageData){
		ArrayList<DtoPerfil> profileResponse = new ArrayList<DtoPerfil>();
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			profileResponse=mgrProfile.findProfiles(perfil, datasource,pageData);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return profileResponse;
	}



}
