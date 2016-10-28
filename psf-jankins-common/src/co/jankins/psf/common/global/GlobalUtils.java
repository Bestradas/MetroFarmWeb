package co.jankins.psf.common.global;

import java.io.File;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.janker.dto.context.Context;

import com.co.farmatech.metrofarm.dto.DtoUsuario;
import com.co.farmatech.metrofarm.dto.DtoPerfil;
import com.co.farmatech.metrofarm.dto.PageData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class GlobalUtils {
	
	
	private static Context contexto;
	
	public static void registerContextInfo(DtoUsuario authUser,DtoPerfil authProfile){
		if(contexto==null){
			contexto=new Context();
			contexto.setLoginUser(authUser);
			contexto.setLoginProfile(authProfile);
			try {
				contexto.setUserIp(Inet4Address.getLocalHost().getHostAddress());
				contexto.setServerId(Inet4Address.getLocalHost().getHostName());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public static Context getContext(){
		return contexto;
	}
	
	public static void cleanContext(){
		contexto=null;
	}
	
	public static String getDateFormatted(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return date!=null?dateFormat.format(date):"";
	}
        
        public static String dateByTimestamp(Date date){
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf.setCalendar(cal);
        cal.setTime(date);
        return sdf.format(date);
        }
        
    	/**
    	 * Gets the paginated query.
    	 *
    	 * @param databasename the databasename
    	 * @param srcquery the srcquery
    	 * @return the paginated query
    	 */
    	public static String getPaginatedQuery(String start,String end,String srcquery) {
    		StringBuffer retorno = new StringBuffer();
    		retorno.append(
    				start)
    				.append(' ')
    				.append(srcquery)
    				.append(' ')
    				.append(end);
    		
    		return retorno.toString();
    	}
    	
    	/**
    	 * Gets the paginated query.
    	 *
    	 * @param databasename the databasename
    	 * @param srcquery the srcquery
    	 * @return the paginated query
    	 */
    	public static String getCountQuery(PageData pageData,Connection con,List<Object> params,String start,String end,String queryCount,String querySql) {
    		
			if (pageData.getRows() == 0) {
				PreparedStatement prepare;
				try {
					prepare = con.prepareStatement(queryCount);

				for (int i = 0; i < params.size(); i++) {
					prepare.setString(i+1,(String)params.get(i));
				}
			
				ResultSet resultCount=prepare.executeQuery();
				if(resultCount.next()){
					pageData.setNumRows(resultCount.getInt("counter"));
					
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
			
			params.add(pageData.getFirstRowNumber());
			params.add(pageData.getLastRowNumber());
			querySql = GlobalUtils.getPaginatedQuery(start,end,querySql);
			
			
			return querySql;
    	}
	
	
	
}
