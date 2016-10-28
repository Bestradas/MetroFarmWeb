package co.com.farmatech.metrofarm.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.com.farmatech.metrofarm.mapper.UserMapper;
import co.com.farmatech.metrofarm.properties.AccessMetroFarmProperties;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.global.GlobalUtils;

import com.co.farmatech.metrofarm.dto.DtoUsuario;
import com.co.farmatech.metrofarm.dto.PageData;

public class UserDaoImpl implements UserDaoService{

	private Properties sqlProperties = AccessMetroFarmProperties.getInstance().getSQLProperties();
	UserMapper userMapper=new UserMapper();

	public DtoUsuario authenticateUser(DtoUsuario usuario,Connection con){
		DtoUsuario valid=null;
		ResultSet r=null;
		DtoUsuario user=null;

		PreparedStatement p = null;
		try {
			p = con.prepareStatement(sqlProperties.getProperty("users.authenticate"));
			p.setString(1, usuario.getUsuario());
			p.setString(2, usuario.getContrasena());
			r = p.executeQuery();
			user=userMapper.authenticateUserMapper(r);
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new JankinsMarshallException("Ocurrio un error realizando el rollback",e);
			}
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

		return user;

	}

	@Override
	public DtoUsuario userByDocument(DtoUsuario usuario, Connection con) {
		DtoUsuario valid=null;
		ResultSet r=null;
		DtoUsuario user=null;

		PreparedStatement p = null;
		try {
			p = con.prepareStatement(sqlProperties.getProperty("users.userByDocument"));
			p.setString(1, usuario.getCodigo());
			r = p.executeQuery();
			user=userMapper.authenticateUserMapper(r);
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new JankinsMarshallException("Ocurrio un error realizando el rollback",e);
			}
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

		return user;
	}
	
	@Override
	public boolean isValidUserCreate(DtoUsuario usuario, Connection con) {
		// TODO Auto-generated method stub
		DtoUsuario valid=null;
		ResultSet r=null;
		DtoUsuario user=null;

		PreparedStatement p = null;
		try {
			p = con.prepareStatement(sqlProperties.getProperty("users.validateCreate"));
			p.setString(1, usuario.getCodigo());
			p.setString(2, usuario.getUsuario());
			r = p.executeQuery();
			return userMapper.isValidUserCreate(r);
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new JankinsMarshallException("Ocurrio un error realizando el rollback",e);
			}
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

	@Override
	public DtoUsuario createUser(DtoUsuario usuario, Connection con) {
		// TODO Auto-generated method stub
		ResultSet r;
		PreparedStatement p = null;
		try {
			p = con.prepareStatement(sqlProperties.getProperty("users.createUser"));
			p.setString(1,usuario.getCodigo());
			p.setLong(2, usuario.getTipo());
			p.setString(3, usuario.getNombres());
			p.setString(4, usuario.getApellidos());
			p.setString(5, usuario.getCorreo());
			p.setString(6, usuario.getTelefono1());
			p.setString(7, usuario.getTelefono2());
			p.setString(8, usuario.getCelular());
			p.setString(9, usuario.getUsuario());
			p.setString(10, usuario.getContrasena());
			p.setString(11, usuario.getPregunta());
			p.setString(12, usuario.getRespuesta());
			p.setLong(13, usuario.getPerfil().getCodperfil());
			p.setLong(14, usuario.getEstado());
			int rowsAfect = p.executeUpdate();
			if(rowsAfect>0){
				return usuario;
			}else {
				throw new JankinsMarshallException("No se pudo crear el nuevo usuario");
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new JankinsMarshallException("Ocurrio un error realizando el rollback",e);
			}
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
	
	@Override
	public DtoUsuario updateUser(DtoUsuario usuario, Connection con) {
		// TODO Auto-generated method stub
		ResultSet r;
		PreparedStatement p = null;
		try {
			p = con.prepareStatement(sqlProperties.getProperty("users.updateUser"));
			p.setLong(1, usuario.getTipo());
			p.setString(2, usuario.getNombres());
			p.setString(3, usuario.getApellidos());
			p.setString(4, usuario.getCorreo());
			p.setString(5, usuario.getTelefono1());
			p.setString(6, usuario.getTelefono2());
			p.setString(7, usuario.getCelular());
			p.setString(8, usuario.getUsuario());
			p.setString(9, usuario.getContrasena());
			p.setString(10, usuario.getPregunta());
			p.setString(11, usuario.getRespuesta());
			p.setLong(12, usuario.getPerfil().getCodperfil());
			p.setLong(13, usuario.getEstado());
			p.setString(14,usuario.getCodigo());
			int i = p.executeUpdate();
			if(i>0){
				return usuario;
			}else{
				throw new JankinsMarshallException("No se pudo actualizar el registro");
			}
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new JankinsMarshallException("Ocurrio un error realizando el rollback",e);
			}
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
	
	@Override
	public ArrayList<DtoUsuario> findUsers(DtoUsuario usuario, Connection con,PageData pageData) {
		// TODO Auto-generated method stub
		ArrayList<DtoUsuario> users=new ArrayList<DtoUsuario>();
		ResultSet r=null;
		PreparedStatement p = null;
		List<Object> params=new ArrayList<Object>();
		String sqlQuery=sqlProperties.getProperty("users.findUsers");
		String q=sqlProperties.getProperty("users.findUsersCount");
		String alternativeQuery="";
		
		if(usuario!=null && usuario.getCodigo()!=null){
			alternativeQuery+="AND U.numeroId='"+usuario.getCodigo()+"'";
		}
		sqlQuery+=alternativeQuery;
		q+=alternativeQuery;
		
		try {
			if(pageData!=null){
				sqlQuery=GlobalUtils.getCountQuery(pageData, con,params,sqlProperties.getProperty("pagination.start"),sqlProperties.getProperty("pagination.end"),q,sqlQuery);
			}
			Connection connection=DataSourceConnector.getInstance().getConexion();	
			p = connection.prepareStatement(sqlQuery);
			for (int i = 0; i < params.size(); i++) {
				if(params.get(i) instanceof Integer){
					p.setInt(i+1,(Integer)params.get(i));
				}else{
					p.setString(i+1,(String)params.get(i));
				}
			}
			r = p.executeQuery();
			users=userMapper.findUserMapper(r);
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				throw new JankinsMarshallException("Ocurrio un error realizando el rollback",e);
			}
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

		return users;
	}
	
	 
	
	
	
	
	

}
