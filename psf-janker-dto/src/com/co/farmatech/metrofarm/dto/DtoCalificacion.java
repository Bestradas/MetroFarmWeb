package com.co.farmatech.metrofarm.dto;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="Calificacion")
public class DtoCalificacion {
    
    DtoEquipo equipo;
    byte[] fileDiseno,FileInstalacion,FileOperacion,Filedesempeno;
    ArrayList<DtoProgramCalificacion> programCalif;
   
	public DtoEquipo getEquipo() {
		return equipo;
	}
	@XmlElement(name="EquipoCalificacion")
	public void setEquipo(DtoEquipo equipo) {
		this.equipo = equipo;
	}
	public byte[] getFileDiseno() {
		return fileDiseno;
	}
	@XmlElement(name="ArchivoDiseno")
	public void setFileDiseno(byte[] fileDiseno) {
		this.fileDiseno = fileDiseno;
	}
	public byte[] getFileInstalacion() {
		return FileInstalacion;
	}
	@XmlElement(name="ArchivoInstalacion")
	public void setFileInstalacion(byte[] fileInstalacion) {
		FileInstalacion = fileInstalacion;
	}
	public byte[] getFileOperacion() {
		return FileOperacion;
	}
	@XmlElement(name="ArchivoOperacion")
	public void setFileOperacion(byte[] fileOperacion) {
		FileOperacion = fileOperacion;
	}
	public byte[] getFiledesempeno() {
		return Filedesempeno;
	}
	@XmlElement(name="ArchivoDesempeno")
	public void setFiledesempeno(byte[] filedesempeno) {
		Filedesempeno = filedesempeno;
	}
	public ArrayList<DtoProgramCalificacion> getProgramCalif() {
		return programCalif;
	}
	@XmlElement(name="ProgramacionCalificaciones")
	public void setProgramCalif(ArrayList<DtoProgramCalificacion> programCalif) {
		this.programCalif = programCalif;
	}
	
	@Override
	public String toString() {
		return "DtoCalificacion [equipo=" + equipo + ", fileDiseno=" + fileDiseno + ", FileInstalacion="
				+ FileInstalacion +", FileOperacion=" + FileOperacion + ", Filedesempeno=" + Filedesempeno + ", programCalif="
				+ programCalif + "]";
	}
	
}