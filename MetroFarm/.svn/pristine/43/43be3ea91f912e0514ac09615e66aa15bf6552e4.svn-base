package co.com.farmatech.metrofarm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.jankins.psf.common.exception.JankinsMarshallException;
import com.co.farmatech.metrofarm.dto.DtoProveedor;

public class ProviderMapper {
	
	public ArrayList<DtoProveedor> findProviders(ResultSet resultSet){
		ArrayList<DtoProveedor> providersList=new ArrayList<DtoProveedor>();
		try {
			while(resultSet.next()){
				//Equipos
				DtoProveedor provider = new DtoProveedor();
				provider.setNit(resultSet.getString("NIT"));
				provider.setNombre(resultSet.getString("NOMBRE"));
				providersList.add(provider);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException("Ocurrio un error mapeando el resultado de findProviders",e);
		}
		
		return providersList;
	}

}
