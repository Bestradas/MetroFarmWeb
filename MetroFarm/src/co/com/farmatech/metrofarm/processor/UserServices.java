package co.com.farmatech.metrofarm.processor;

import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoUsuario;
import com.co.farmatech.metrofarm.dto.PageData;

import co.com.farmatech.metrofarm.bimanager.user.MgrUsuarioImpl;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.operations.Operations;

public class UserServices implements ProcessService {

	private MgrUsuarioImpl mgrUsuarios=new MgrUsuarioImpl();

	public Object doProcess(ObjectSend send){
		switch (send.getOperation()) {
		//AUTHENTICATE_USER
		case Operations.AUTHENTICATE_USER:
			return authenticateUser((DtoUsuario)send.getObj());

			//USER_BY_DOCUMENT
		case Operations.USER_BY_DOCUMENT:
			return userByDocument((DtoUsuario)send.getObj());

			//USER_BY_DOCUMENT
		case Operations.FIND_USERS:
			return findUsers((DtoUsuario)send.getObj(),send.getPageData());

			//CREATE_USER
		case Operations.CREATE_USER:
			return createUser((DtoUsuario)send.getObj());

			//UPDATE_USER
		case Operations.UPDATE_USER:
			return updateUser((DtoUsuario)send.getObj());

		default:
			break;
		}
		return send.getObj()!=null?send.getObj():send.getRecords();

	}


	public DtoUsuario authenticateUser(DtoUsuario usuario){
		DtoUsuario userResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			userResponse=mgrUsuarios.authenticateUser(usuario, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return userResponse;
	}

	public DtoUsuario userByDocument(DtoUsuario usuario){
		DtoUsuario userResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			userResponse=mgrUsuarios.userByDocument(usuario, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return userResponse;
	}
	
	public ArrayList<DtoUsuario> findUsers(DtoUsuario usuario,PageData pageData){
		ArrayList<DtoUsuario> userResponse = new ArrayList<DtoUsuario>();
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			userResponse=mgrUsuarios.findUsers(usuario, datasource,pageData);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return userResponse;
	}

	public DtoUsuario createUser(DtoUsuario usuario){
		DtoUsuario userResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			userResponse=mgrUsuarios.createUser(usuario, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return userResponse;
	}

	public DtoUsuario updateUser(DtoUsuario usuario){
		DtoUsuario userResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			userResponse=mgrUsuarios.updateUser(usuario, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return userResponse;
	}





}