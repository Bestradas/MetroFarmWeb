package co.jankins.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.co.farmatech.metrofarm.dto.DtoUsuario;

import co.janker.dto.context.Context;
import co.janker.dto.objresponse.ObjectResponse;
import co.janker.dto.objsend.ObjectSend;
import co.janker.dto.processor.ProcessService;
import co.jankins.properties.AccessProperties;
import co.jankins.psf.common.conversion.MarshallServiceImpl;
import co.jankins.psf.common.exception.JankinsMarshallException;
import co.jankins.psf.common.global.GlobalDto;
import co.jankins.psf.common.metrofarm.exception.JankerExceptionEnum;
import co.jankins.psf.common.operations.Operations;
import co.jankins.psf.common.serializable.Serializable;
import co.jankins.psf.common.services.Services;
import co.jankins.psf.common.util.Utilities;

/**
 * Servlet implementation class DoProcess
 */
@WebServlet("/ServletEnvio")
public class DoProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Properties properties = AccessProperties.getInstance().getProperties();




	/**
	 * Default constructor. 
	 */
	public DoProcess() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		envioInformacion(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		envioInformacion(request, response);
	}

	protected void envioInformacion( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		//GET REQUEST DATA
		StringBuffer jb = new StringBuffer();
		try {
			String line = null;
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { /*report an error*/ }
		//Response Writer
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		java.io.Writer write=response.getWriter();
		
		String xmlRespuesta="";
		ObjectResponse obResponse=new ObjectResponse();
		MarshallServiceImpl marshallService=new MarshallServiceImpl();

		try{			
			String mensajeBase64= jb.toString();
			if(mensajeBase64!=null && !mensajeBase64.equals("")){
				//				String mensaje=Serializable.Desencriptar(mensajeBase64);
				ObjectSend obj=(ObjectSend)marshallService.unmarshallXml(mensajeBase64,GlobalDto.dtos);//Obtengo objeto enviado
				validateObjSend(obj);
				Object objremote=ProcessService(obj);//Envio a procesar y consumir servicio

				obResponse.setDescription("Correcto");
				obResponse.setErrorCode("000");
				obResponse.setpageResponse(obj.getPageData());

				if(objremote!=null){
					Class clazz[]=Utilities.getClassObjectResponse(obResponse, objremote);
					xmlRespuesta=marshallService.marshallObject(obResponse,clazz);
				}else{
					xmlRespuesta=marshallService.marshallObject(obResponse, ObjectResponse.class);
				}
			}else{
				throw new JankinsMarshallException("La petici�n enviada es inv�lida","999","El par�metro XML ha llegado vacio o es nulo","Error",123L);
			}

		}catch(JankinsMarshallException je){
			obResponse.setErrorCode(je.getCode());
			obResponse.setDescription(je.getMessage());
			xmlRespuesta=marshallService.marshallObject(obResponse, ObjectResponse.class);
		}catch(Exception ex){
			obResponse.setErrorCode("999");
			obResponse.setDescription(ex.getMessage());
			xmlRespuesta=marshallService.marshallObject(obResponse, ObjectResponse.class);
		}finally{
			write.write(xmlRespuesta);
			write.flush();
			write.close();
			System.gc();
		}
	}


	public void validateObjSend(ObjectSend obj){
		if(obj.getContexto()==null && ((!obj.getOperation().equals(Operations.AUTHENTICATE_USER) && !obj.getOperation().equals(Operations.FORGGET_PASSWORD) && !obj.getOperation().equals(Operations.USER_BY_DOCUMENT))) || (obj.getContexto()!=null && (obj.getContexto().getLoginUser()==null && obj.getContexto().getLoginProfile()==null))){
			throw new JankinsMarshallException(JankerExceptionEnum.E_20000.getDescription(), JankerExceptionEnum.E_20000.getValue(), JankerExceptionEnum.E_20000.getDescription(),"CONTEXT_ERROR", 20000L);
		}
	}

	/**
	 * 
	 * @param send
	 * @return
	 */
	public Object ProcessService(ObjectSend send){		
		Class clase;
		try {
			clase = Class.forName(properties.getProperty("ProcessService"));
			ProcessService objClass =(ProcessService)clase.newInstance();
			return objClass.doProcess(send);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new  JankinsMarshallException("No se ha podido encontrar el procesador de servicios","999",e.getMessage(),"ERROR",1L);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}
	}

}