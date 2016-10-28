package com.co.farmatech.metrofarm.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Reporte")
public class DtoReport {
	
	Date fechaReporte;
    byte[] fileReporte;
	public Date getFechaReporte() {
		return fechaReporte;
	}
	@XmlElement(name="FechaReporte")
	public void setFechaReporte(Date fechaReporte) {
		this.fechaReporte = fechaReporte;
	}
	public byte[] getFileReporte() {
		return fileReporte;
	}
	@XmlElement(name="FileReporte")
	public void setFileReporte(byte[] fileReporte) {
		this.fileReporte = fileReporte;
	}
    
	@Override
	public String toString() {
		return "DtoReport [fechaReporte=" + fechaReporte + ", fileReporte=" + fileReporte + "]";
	}   
    
    

}
