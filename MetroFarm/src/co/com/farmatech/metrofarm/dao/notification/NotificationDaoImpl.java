package co.com.farmatech.metrofarm.dao.notification;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import co.com.farmatech.metrofarm.mapper.NotificationMapper;
import co.com.farmatech.metrofarm.properties.AccessMetroFarmProperties;
import co.jankins.psf.common.exception.JankinsMarshallException;

import com.co.farmatech.metrofarm.dto.DtoNotificacion;

public class NotificationDaoImpl implements NotificationDaoService{
	
	private Properties sqlProperties = AccessMetroFarmProperties.getInstance().getSQLProperties();
	private NotificationMapper mapper=new NotificationMapper();
	
	@Override
	public DtoNotificacion getNotifications(DtoNotificacion notification,
			Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;
		ResultSet r;
		String querySql=sqlProperties.getProperty("notification.get");
		try {
			p = con.prepareStatement(querySql);
			r =p.executeQuery();
			return mapper.getNotifications(r);
		} catch (SQLException e) {
			throw new JankinsMarshallException(e);
		}finally{
			try {
				p.close();
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
