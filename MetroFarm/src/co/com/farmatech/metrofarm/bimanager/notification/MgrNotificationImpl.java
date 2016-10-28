package co.com.farmatech.metrofarm.bimanager.notification;

import co.com.farmatech.metrofarm.dao.notification.NotificationDaoImpl;
import co.com.farmatech.metrofarm.dao.notification.NotificationDaoService;
import co.com.farmatech.metrofarm.datasource.DataSourceConnector;

import com.co.farmatech.metrofarm.dto.DtoNotificacion;

public class MgrNotificationImpl implements MgrNotificationService{

	NotificationDaoService notificationDao=new NotificationDaoImpl();
	
	@Override
	public DtoNotificacion getNotifications(DtoNotificacion notification,
			DataSourceConnector source) {
		// TODO Auto-generated method stub
		return notificationDao.getNotifications(notification, source.getConexion());
	}

}
