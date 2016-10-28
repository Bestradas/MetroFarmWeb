package com.co.farmatech.metrofarm.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Mantenimiento")
public class DtoMantenimiento {

    String numFom, responsable, recibido,anomalias, labores, observaciones, proovedores;
    BigDecimal Precio;
    DtoEquipo equipo;
    DtoUsuario registrado;
    Date fechaRegistro,FechaProximo,fechaEjecutado;
    Long tipoMant;
    long cumplio;

	public String getNumFom() {
		return numFom;
	}
	@XmlElement(name="NumeroFormulario")
	public void setNumFom(String numFom) {
		this.numFom = numFom;
	}
	public Long getTipoMant() {
		return tipoMant;
	}
	@XmlElement(name="TipoMantenimiento")
	public void setTipoMant(Long tipoMant) {
		this.tipoMant = tipoMant;
	}
	public String getResponsable() {
		return responsable;
	}
	@XmlElement(name="Responsable")
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getRecibido() {
		return recibido;
	}
	@XmlElement(name="Recibido")
	public void setRecibido(String recibido) {
		this.recibido = recibido;
	}
	public String getAnomalias() {
		return anomalias;
	}
	@XmlElement(name="Anomalias")
	public void setAnomalias(String anomalias) {
		this.anomalias = anomalias;
	}
	public String getLabores() {
		return labores;
	}
	@XmlElement(name="Labores")
	public void setLabores(String labores) {
		this.labores = labores;
	}
	public String getObservaciones() {
		return observaciones;
	}
	@XmlElement(name="Observaciones")
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getProovedores() {
		return proovedores;
	}
	@XmlElement(name="Proovedores")
	public void setProovedores(String proovedores) {
		this.proovedores = proovedores;
	}
	public BigDecimal getPrecio() {
		return Precio;
	}
	@XmlElement(name="Precio")
	public void setPrecio(BigDecimal precio) {
		Precio = precio;
	}
	public DtoEquipo getEquipo() {
		return equipo;
	}
	@XmlElement(name="Equipo")
	public void setEquipo(DtoEquipo equipo) {
		this.equipo = equipo;
	}
	public DtoUsuario getRegistrado() {
		return registrado;
	}
	@XmlElement(name="Registrado")
	public void setRegistrado(DtoUsuario registrado) {
		this.registrado = registrado;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	@XmlElement(name="FechaRegistro")
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaProximo() {
		return FechaProximo;
	}
	@XmlElement(name="FechaProximo")
	public void setFechaProximo(Date fechaProximo) {
		FechaProximo = fechaProximo;
	}
	public Date getFechaEjecutado() {
		return fechaEjecutado;
	}
	@XmlElement(name="FechaEjecutado")
	public void setFechaEjecutado(Date fechaEjecutado) {
		this.fechaEjecutado = fechaEjecutado;
	}
	public long getCumplio() {
		return cumplio;
	}
	@XmlElement(name="Cumplio")
	public void setCumplio(long cumplio) {
		this.cumplio = cumplio;
	}
	
	@Override
	public String toString() {
		return "DtoMantenimiento [numFom=" + numFom + ", responsable=" + responsable + ", recibido="
				+ recibido +", anomalias=" + anomalias + ", labores=" + labores + ", observaciones="
				+ observaciones + ", proovedores=" + proovedores + ", Precio="+ Precio +", equipo=" 
				+ equipo + ", registrado=" + registrado + ", fechaRegistro="+ fechaRegistro +", FechaProximo=" 
				+ FechaProximo + ", fechaEjecutado="+ fechaEjecutado +", tipoMant=" + tipoMant +", cumplio=" + cumplio +"]";
	}
	
}
