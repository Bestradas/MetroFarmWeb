package co.janker.dto.profile;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Perfil")
public class Profile {
	
	private long profileId;
	private String profileName;
	private ArrayList<String> profilePermision;
	
	
	public long getProfileId() {
		return profileId;
	}
	@XmlElement(name = "Id")
	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}
	
	public String getProfileName() {
		return profileName;
	}
	@XmlElement(name = "NombrePerfil")
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public ArrayList<String> getProfilePermision() {
		return profilePermision;
	}
	@XmlElementWrapper
	@XmlElement(name = "Permisos")
	public void setProfilePermision(ArrayList<String> profilePermision) {
		this.profilePermision = profilePermision;
	}
	    
	
	

}
