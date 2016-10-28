package co.com.farmatech.metrofarm.processor;

import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.DtoRegistroCambios;

import co.com.farmatech.metrofarm.bimanager.changeregister.MgrChangeRegisterImpl;
import co.com.farmatech.metrofarm.bimanager.changeregister.MgrChangeRegisterService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.operations.Operations;

public class ChangeRegisterService implements ProcessService {

	MgrChangeRegisterService mgrChange=new MgrChangeRegisterImpl();
	
	@Override
	public Object doProcess(ObjectSend send) {
		// TODO Auto-generated method stub
		switch (send.getOperation()) {
		//FIND_EQUIPMENT
		case Operations.CREATE_CHANGE_REGISTER:
			return createChangeRegister((DtoRegistroCambios)send.getObj());
		
		case Operations.LIST_CHANGE_REGISTER:
			return listChangeRegister((DtoRegistroCambios)send.getObj());

		default:
			break;
		}
		return send.getObj()!=null?send.getObj():send.getRecords();
	}
	
	public DtoRegistroCambios createChangeRegister(DtoRegistroCambios registroEquipo){
		DtoRegistroCambios DtoRegistroCambios = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			DtoRegistroCambios=mgrChange.createChangeRegister(registroEquipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return DtoRegistroCambios;
	}
	
	public ArrayList<DtoRegistroCambios> listChangeRegister(DtoRegistroCambios registroEquipo){
		ArrayList<DtoRegistroCambios> DtoRegistroCambios = new ArrayList<DtoRegistroCambios>();
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			DtoRegistroCambios=mgrChange.listChangeRegister(registroEquipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return DtoRegistroCambios;
	}

}
