package co.com.farmatech.metrofarm.processor;

import com.co.farmatech.metrofarm.dto.DtoNotificacion;
import com.co.farmatech.metrofarm.dto.DtoProveedor;

import co.com.farmatech.metrofarm.bimanager.notification.MgrNotificationImpl;
import co.com.farmatech.metrofarm.bimanager.notification.MgrNotificationService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.psf.common.operations.Operations;

public class NotificationServices implements ProcessService {

	MgrNotificationService mgrNotification=new MgrNotificationImpl();
	
	@Override
	public Object doProcess(ObjectSend send) {
		// TODO Auto-generated method stub
		switch (send.getOperation()) {
		case Operations.GET_NOTIFICATIONS:
			return getNotifications((DtoNotificacion)send.getObj());

		default:
			break;
		}
		return send.getObj()!=null?send.getObj():send.getRecords();
	}
	
	public DtoNotificacion getNotifications(DtoNotificacion notif){
		DtoNotificacion notification=null;
		DataSourceConnector datasource = DataSourceConnector.getInstance();
		notification = mgrNotification.getNotifications(notification, datasource);
		return notification;
	}

}
