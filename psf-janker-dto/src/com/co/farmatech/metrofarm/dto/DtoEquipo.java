package com.co.farmatech.metrofarm.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Equipo")
public class DtoEquipo {

    private String codigoInv, codigoMet, marca, modelo, serie, nombre, ubicacion,observaciones,extencion,cliente;
    private Long estado,tipo;
    private Long frecMantenimiento,frecCalibracion,frecCalifOPerativa,frecCalifDesempenio;
    private byte[] Foto;
    private Date Fecha;
    
	public String getCodigoInv() {
		return codigoInv;
	}
	@XmlElement(name="CodigoInventario")
	public void setCodigoInv(String codigoInv) {
		this.codigoInv = codigoInv;
	}
	public String getCodigoMet() {
		return codigoMet;
	}
	@XmlElement(name="CodigoMetrologia")
	public void setCodigoMet(String codigoMet) {
		this.codigoMet = codigoMet;
	}
	public String getMarca() {
		return marca;
	}
	@XmlElement(name="Marca")
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	@XmlElement(name="Modelo")
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getSerie() {
		return serie;
	}
	@XmlElement(name="NumeroSerie")
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getNombre() {
		return nombre;
	}
	@XmlElement(name="NombreEquipo")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	@XmlElement(name="UbicacionEquipo")
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	@XmlElement(name="Observaciones")
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getExtencion() {
		return extencion;
	}
	@XmlElement(name="ExtencionFoto")
	public void setExtencion(String extencion) {
		this.extencion = extencion;
	}
	public String getCliente() {
		return cliente;
	}
	@XmlElement(name="Cliente")
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Long getEstado() {
		return estado;
	}
	@XmlElement(name="Estado")
	public void setEstado(Long estado) {
		this.estado = estado;
	}
	public Long getTipo() {
		return tipo;
	}
	@XmlElement(name="TipoEquipo")
	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}
	public Long getFrecMantenimiento() {
		return frecMantenimiento;
	}
	@XmlElement(name="FrecuenciaMantenimiento")
	public void setFrecMantenimiento(Long frecMantenimiento) {
		this.frecMantenimiento = frecMantenimiento;
	}
	public Long getFrecCalibracion() {
		return frecCalibracion;
	}
	@XmlElement(name="FrecuenciaCalibracion")
	public void setFrecCalibracion(Long frecCalibracion) {
		this.frecCalibracion = frecCalibracion;
	}
	public Long getFrecCalifOPerativa() {
		return frecCalifOPerativa;
	}
	@XmlElement(name="FrecuenciaCalificacionOperativa")
	public void setFrecCalifOPerativa(Long frecCalifOPerativa) {
		this.frecCalifOPerativa = frecCalifOPerativa;
	}

	public Long getFrecCalifDesempenio() {
		return frecCalifDesempenio;
	}
	@XmlElement(name="FrecuenciaCalificacionDesempenio")
	public void setFrecCalifDesempenio(Long frecCalifDesempenio) {
		this.frecCalifDesempenio = frecCalifDesempenio;
	}
	public byte[] getFoto() {
		return Foto;
	}
	@XmlElement(name="Foto")
	public void setFoto(byte[] foto) {
		Foto = foto;
	}
	public Date getFecha() {
		return Fecha;
	}
	@XmlElement(name="FechaIngreso")
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
        
        

    
    
    
}