package co.com.farmatech.metrofarm.processor;

import java.util.ArrayList;





import com.co.farmatech.metrofarm.dto.DtoEquipo;
import com.co.farmatech.metrofarm.dto.PageData;

import co.com.farmatech.metrofarm.bimanager.equipment.MgrEquipmentImpl;
import co.com.farmatech.metrofarm.bimanager.equipment.MgrEquipmentService;
import co.com.farmatech.metrofarm.bimanager.synchronization.MgrSynchronizationImp;
import co.com.farmatech.metrofarm.bimanager.synchronization.MgrSynchronizationService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.operations.Operations;

public class EquipmentServices implements ProcessService{

	MgrEquipmentService mgrEquipment=new MgrEquipmentImpl();
	MgrSynchronizationService mgrSynchronice=new MgrSynchronizationImp();

	public Object doProcess(ObjectSend send){
		switch (send.getOperation()) {
		//FIND_EQUIPMENT
		case Operations.FIND_EQUIPMENT:
			return findEquipment(send.getObj() instanceof DtoEquipo ?(DtoEquipo)send.getObj():new DtoEquipo(),send.getPageData());

			//FIND_EQUIPMENT_EXIST
		case Operations.FIND_EQUIPMENT_EXIST:
			return findEquipmentExist((DtoEquipo)send.getObj());


			//CREATE_EQUIPMENT
		case Operations.CREATE_EQUIPMENT:
			return createEquipment((DtoEquipo)send.getObj());

			//UPDATE_EQUIPMENT
		case Operations.UPDATE_EQUIPMENT:
			return updateEquipment((DtoEquipo)send.getObj());

			//UPDATE_EQUIPMENT
		case Operations.SYNCHRONICE:
			return synchroniceEquipment((DtoEquipo)send.getObj());

		default:
			break;
		}
		return send.getObj()!=null?send.getObj():send.getRecords();

	}


	public ArrayList<DtoEquipo> findEquipment(DtoEquipo equipo,PageData pageData){
		ArrayList<DtoEquipo> equipments = new ArrayList<DtoEquipo>();
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			equipments=mgrEquipment.findEquipment(equipo, datasource,pageData);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return equipments;
	}

	public DtoEquipo findEquipmentExist(DtoEquipo equipo){

		DataSourceConnector datasource = DataSourceConnector.getInstance();
		try {
			return mgrEquipment.findEquipmentExist(equipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

	}


	public DtoEquipo createEquipment(DtoEquipo equipo){
		DtoEquipo equipmentResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			equipmentResponse=mgrEquipment.createEquipment(equipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return equipmentResponse;
	}

	public DtoEquipo updateEquipment(DtoEquipo equipo){
		DtoEquipo equipmentResponse = null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();

		try {
			equipmentResponse=mgrEquipment.updateEquipment(equipo, datasource);
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}finally{
			
		}

		return equipmentResponse;
	}

	public DtoEquipo synchroniceEquipment(DtoEquipo equipo){
		DtoEquipo equipmentResponse = new DtoEquipo();

		try {
			mgrSynchronice.execute();
		} catch (Exception e) {
			throw new JankinsMarshallException(e);
		}

		return equipmentResponse;
	}

}
