package co.com.farmatech.metrofarm.processor;

import com.co.farmatech.metrofarm.dto.DtoUsuario;

import co.com.farmatech.metrofarm.bimanager.user.MgrUsuarioImpl;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.operations.Operations;
import co.jankins.psf.common.util.SendEmail;

public class EmailServices implements ProcessService {
	
	
	public Object doProcess(ObjectSend send){
		switch (send.getOperation()) {
		//FORGGET_PASSWORD
		case Operations.FORGGET_PASSWORD:
			return getPassword((DtoUsuario)send.getObj());
		
		default:
			break;
		}
		return send.getObj()!=null?send.getObj():send.getRecords();
		
	}
	
	public DtoUsuario getPassword(DtoUsuario usuario){
		DtoUsuario userResponse = new DtoUsuario();
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			SendEmail sendEmail=new SendEmail(usuario);
			sendEmail.Enviar();
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}
		
		return userResponse;
	}

}
