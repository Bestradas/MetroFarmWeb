package com.co.farmatech.metrofarm.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Calibracion")
public class DtoCalibracion {
    
	String codigoCalibracion;
	DtoEquipo equipo;
	String proveedor;
    String  division, exactitud, valMininmo, valMaximo,rangCalibracion,RangTrabajo;
    Date fechaRegistro,proximaCalibracion,FechaEjecutada;
    byte[] archivo;
    BigDecimal Precio;
    long cumplio;
    
    
    
	public String getCodigoCalibracion() {
		return codigoCalibracion;
	}
	@XmlElement(name="CodigoCalibracion")
	public void setCodigoCalibracion(String codigoCalibracion) {
		this.codigoCalibracion = codigoCalibracion;
	}
	public DtoEquipo getEquipo() {
		return equipo;
	}
	@XmlElement(name="EquipoCalibracion")
	public void setEquipo(DtoEquipo equipo) {
		this.equipo = equipo;
	}
	public String getProveedor() {
		return proveedor;
	}
	@XmlElement(name="ProveedorCalibracion")
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getDivision() {
		return division;
	}
	@XmlElement(name="Division")
	public void setDivision(String division) {
		this.division = division;
	}
	public String getExactitud() {
		return exactitud;
	}
	@XmlElement(name="Exactitud")
	public void setExactitud(String exactitud) {
		this.exactitud = exactitud;
	}
	public String getValMininmo() {
		return valMininmo;
	}
	@XmlElement(name="ValMininmo")
	public void setValMininmo(String valMininmo) {
		this.valMininmo = valMininmo;
	}
	public String getValMaximo() {
		return valMaximo;
	}
	@XmlElement(name="ValMaximo")
	public void setValMaximo(String valMaximo) {
		this.valMaximo = valMaximo;
	}
	public String getRangCalibracion() {
		return rangCalibracion;
	}
	@XmlElement(name="RangCalibracion")
	public void setRangCalibracion(String rangCalibracion) {
		this.rangCalibracion = rangCalibracion;
	}
	public String getRangTrabajo() {
		return RangTrabajo;
	}
	@XmlElement(name="RangTrabajo")
	public void setRangTrabajo(String rangTrabajo) {
		RangTrabajo = rangTrabajo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	@XmlElement(name="FechaRegistro")
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getProximaCalibracion() {
		return proximaCalibracion;
	}
	@XmlElement(name="ProximaCalibracion")
	public void setProximaCalibracion(Date proximaCalibracion) {
		this.proximaCalibracion = proximaCalibracion;
	}
	public Date getFechaEjecutada() {
		return FechaEjecutada;
	}
	@XmlElement(name="FechaEjecutada")
	public void setFechaEjecutada(Date fechaEjecutada) {
		FechaEjecutada = fechaEjecutada;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	@XmlElement(name="Archivo")
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public BigDecimal getPrecio() {
		return Precio;
	}
	@XmlElement(name="Precio")
	public void setPrecio(BigDecimal precio) {
		Precio = precio;
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
		return "DtoCalibracion [codigoCalibracion=" + codigoCalibracion + ", equipo=" + equipo + ", proveedor="
				+ proveedor +", division=" + division + ", exactitud=" + exactitud + ", valMininmo="
				+ valMininmo + ", valMaximo=" + valMaximo + ", rangCalibracion=" + rangCalibracion + ", RangTrabajo="
				+ RangTrabajo +", fechaRegistro=" + fechaRegistro + ", proximaCalibracion=" + proximaCalibracion + ", FechaEjecutada="
				+ FechaEjecutada + ", archivo=" + archivo + ", Precio="+ Precio + ", cumplio=" + cumplio+ "]";
	}
    

    
    
    
}
