package co.jankins.security.filters;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import co.janker.dto.objresponse.ObjectResponse;
import co.jankins.psf.common.conversion.MarshallServiceImpl;

public class SecurityParameterFilter implements Filter{

	private String m_fieldFilterErrorCode = "900";
	private boolean m_fieldFilterEnableFlag;
	ObjectResponse obResponse=new ObjectResponse();

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String xmlRespuesta="";
		java.io.Writer write=servletResponse.getWriter();
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		boolean process=true;
		String urlReq = httpServletRequest.getRequestURL().toString();
		if(!urlReq.contains("authentication") && !urlReq.contains("initApplication")){
			if ((m_fieldFilterEnableFlag ? !checkXssAttack(servletRequest) : false)) {
				MarshallServiceImpl marshallService=new MarshallServiceImpl();
				xmlRespuesta=marshallService.marshallObject(obResponse, ObjectResponse.class);
			}
		}
		if(process) {
			chain.doFilter(servletRequest, servletResponse);
		}else{
			write.write(xmlRespuesta);
			write.flush();
			write.close();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	private boolean checkXssAttack(ServletRequest servletRequest) {

		boolean _result = true;
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		String _value = null;
		BufferedReader reader;
		try {
			reader = httpServletRequest.getReader();
			while ((_value = reader.readLine()) != null) {
				_result = Validator.validateXSS(_value);

				if (!_result) {
					obResponse.setErrorCode(m_fieldFilterErrorCode);
					obResponse.setDescription("******SE HA DETECTADO UN INTENTO DE ATAQUE XSS******"+
							"******INTENTO ATAQUE XSS - URL: "+ httpServletRequest.getRequestURL()+"\n"+
							"******INTENTO ATAQUE XSS - IP: "+ httpServletRequest.getRequestURL()+"\n"+
							"******INTENTO ATAQUE XSS - SESSION ID: "+ httpServletRequest.getRemoteAddr()+"\n"+
							"******INTENTO ATAQUE XSS - USER: "+httpServletRequest.getUserPrincipal());


					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _result;
	}



}
