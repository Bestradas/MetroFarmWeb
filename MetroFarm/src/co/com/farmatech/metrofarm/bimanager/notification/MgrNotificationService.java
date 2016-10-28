package co.com.farmatech.metrofarm.bimanager.notification;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;

import com.co.farmatech.metrofarm.dto.DtoNotificacion;

public interface MgrNotificationService {
	
	/**
	 * 
	 * @param notification
	 * @param source
	 * @return
	 */
	public DtoNotificacion getNotifications(DtoNotificacion notification,DataSourceConnector source);

}
