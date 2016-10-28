package co.com.farmatech.metrofarm.dao.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.co.farmatech.metrofarm.dto.DtoUsuario;
import com.co.farmatech.metrofarm.dto.PageData;

public interface UserDaoService {
	
	/**
	 * 
	 * @param usuario
	 * @param con
	 * @return
	 */
	public DtoUsuario authenticateUser(DtoUsuario usuario,Connection con);
	/**
	 * 
	 * @param usuario
	 * @param con
	 * @return
	 */
	public DtoUsuario userByDocument(DtoUsuario usuario,Connection con);
	/**
	 * 
	 * @param usuario
	 * @param con
	 * @return
	 */
	public boolean isValidUserCreate(DtoUsuario usuario, Connection con);
	/**
	 * 
	 * @param usuario
	 * @param con
	 * @return
	 */
	public DtoUsuario createUser(DtoUsuario usuario, Connection con);
	
	/**
	 * 
	 * @param usuario
	 * @param con
	 * @return
	 */
	public DtoUsuario updateUser(DtoUsuario usuario, Connection con);
	
	/**
	 * 
	 * @param usuario
	 * @param con
	 * @return
	 */
	public ArrayList<DtoUsuario> findUsers(DtoUsuario usuario,Connection con,PageData pageData);

}