package co.jankins.datasource;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.com.farmatech.metrofarm.datasource.DataSourceConnector;
import co.com.farmatech.metrofarm.properties.AccessMetroFarmProperties;
import co.jankins.properties.AccessProperties;

/**
 * Servlet implementation class InitDataSource
 */
@WebServlet("/InitDataSource")
public class InitDataSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitDataSource() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try{
			AccessProperties.getInstance();
			AccessMetroFarmProperties.getInstance();
			DataSourceConnector.getInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
