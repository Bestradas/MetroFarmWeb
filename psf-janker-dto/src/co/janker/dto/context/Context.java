package co.janker.dto.context;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.co.farmatech.metrofarm.dto.DtoUsuario;
import com.co.farmatech.metrofarm.dto.DtoPerfil;

@XmlRootElement(name="Contexto")
public class Context {
	
	private String serverId,userIp;
	private DtoUsuario loginUser;
	private DtoPerfil    loginProfile;

	public String getServerId() {
		return serverId;
	}
	@XmlElement(name="ServerId")
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getUserIp() {
		return userIp;
	}
	@XmlElement(name="UserIp")
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public DtoUsuario getLoginUser() {
		return loginUser;
	}
	@XmlElement(name="LoginUser")
	public void setLoginUser(DtoUsuario loginUser) {
		this.loginUser = loginUser;
	}
	public DtoPerfil getLoginProfile() {
		return loginProfile;
	}
	@XmlElement(name="LoginProfile")
	public void setLoginProfile(DtoPerfil loginProfile) {
		this.loginProfile = loginProfile;
	}
	
	@Override
	public String toString() {
		 return "Context [serverId=" + serverId + ", userIp=" + userIp + ", loginUser="
					+ loginUser +", loginProfile=" + loginProfile + "]";

	}

		
	
	
	
	

}
