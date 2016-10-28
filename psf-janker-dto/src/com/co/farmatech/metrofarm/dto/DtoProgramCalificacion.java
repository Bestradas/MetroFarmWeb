package com.co.farmatech.metrofarm.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Calificacion")
public class DtoProgramCalificacion {
	 DtoEquipo equipo;
	 Date fechaUltimaCalificacion,fechaRegistro,fechaProxima,fechaEjecucion;
	 Long tipoCalificacion,codigoProgramacion;
	 int cumplimiento;
	 
	 
	public Long getCodigoProgramacion() {
		return codigoProgramacion;
	}
	@XmlElement(name="CodigoProgramacionCalificacion")
	public void setCodigoProgramacion(Long codigoProgramacion) {
		this.codigoProgramacion = codigoProgramacion;
	}
	public DtoEquipo getEquipo() {
		return equipo;
	}
	@XmlElement(name="EquipoProgramacionCalificacion")
	public void setEquipo(DtoEquipo equipo) {
		this.equipo = equipo;
	}
	public Date getFechaUltimaCalificacion() {
		return fechaUltimaCalificacion;
	}
	@XmlElement(name="UltimaCalificacion")
	public void setFechaUltimaCalificacion(Date fechaUltimaCalificacion) {
		this.fechaUltimaCalificacion = fechaUltimaCalificacion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	@XmlElement(name="FechaRegistro")
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaProxima() {
		return fechaProxima;
	}
	@XmlElement(name="FechaProxima")
	public void setFechaProxima(Date fechaProxima) {
		this.fechaProxima = fechaProxima;
	}
	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}
	@XmlElement(name="FechaEjecucion")
	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}
	public Long getTipoCalificacion() {
		return tipoCalificacion;
	}
	@XmlElement(name="TipoCalificacion")
	public void setTipoCalificacion(Long tipoCalificacion) {
		this.tipoCalificacion = tipoCalificacion;
	}
	public int getCumplimiento() {
		return cumplimiento;
	}
	@XmlElement(name="Cumplio")
	public void setCumplimiento(int cumplimiento) {
		this.cumplimiento = cumplimiento;
	}
	 
	 
	 
}