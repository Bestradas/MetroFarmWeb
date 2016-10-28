package co.janker.dto.user;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ObjetoUsuario")
public class User {
	
	private String name;
	
	private String lastName;
	
	private ArrayList<String> celphones;
	
	public String getName() {
		return name;
	}
	@XmlElement(name="Nombre")
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	@XmlElement(name="Apellido")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public ArrayList<String> getCelphones() {
		return celphones;
	}
	@XmlElementWrapper
	@XmlElement(name="Telefonos")
	public void setCelphones(ArrayList<String> celphones) {
		this.celphones = celphones;
	}

	
	
	
	
	
}
