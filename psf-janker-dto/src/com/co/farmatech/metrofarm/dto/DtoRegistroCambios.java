package com.co.farmatech.metrofarm.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DtoRegistroCambios {
	 String Codigo,Aplicado,cual,solicitado,Area,prioridad,tipodoc,otro,situactual,situpropuesta,razoncambio,clasifcambio,tipocambio,lote,op,tamno,justificacion;
         DtoEquipo equipoRegistro;
     Date Fecha,Fecha2;
         
	    public String getCodigo() {
	        return Codigo;
	    }
	    @XmlElement
	    public void setCodigo(String Codigo) {
	        this.Codigo = Codigo;
	    }

	    public Date getFecha() {
	        return Fecha;
	    }
	    @XmlElement
	    public void setFecha(Date Fecha) {
	        this.Fecha = Fecha;
	    }

	    public String getAplicado() {
	        return Aplicado;
	    }
	    @XmlElement
	    public void setAplicado(String Aplicado) {
	        this.Aplicado = Aplicado;
	    }

	    public String getCual() {
	        return cual;
	    }
	    @XmlElement
	    public void setCual(String cual) {
	        this.cual = cual;
	    }

	    public String getSolicitado() {
	        return solicitado;
	    }
	    @XmlElement
	    public void setSolicitado(String solicitado) {
	        this.solicitado = solicitado;
	    }

	    public Date getFecha2() {
	        return Fecha2;
	    }
	    @XmlElement
	    public void setFecha2(Date Fecha2) {
	        this.Fecha2 = Fecha2;
	    }

	    public String getArea() {
	        return Area;
	    }
	    @XmlElement
	    public void setArea(String Area) {
	        this.Area = Area;
	    }

	    public String getPrioridad() {
	        return prioridad;
	    }
	    @XmlElement
	    public void setPrioridad(String prioridad) {
	        this.prioridad = prioridad;
	    }

	    public String getTipodoc() {
	        return tipodoc;
	    }
	    @XmlElement
	    public void setTipodoc(String tipodoc) {
	        this.tipodoc = tipodoc;
	    }

	    public String getOtro() {
	        return otro;
	    }
	    @XmlElement
	    public void setOtro(String otro) {
	        this.otro = otro;
	    }

	    public String getSituactual() {
	        return situactual;
	    }
	    @XmlElement
	    public void setSituactual(String situactual) {
	        this.situactual = situactual;
	    }

	    public String getSitupropuesta() {
	        return situpropuesta;
	    }
	    @XmlElement
	    public void setSitupropuesta(String situpropuesta) {
	        this.situpropuesta = situpropuesta;
	    }

	    public String getRazoncambio() {
	        return razoncambio;
	    }
	    @XmlElement
	    public void setRazoncambio(String razoncambio) {
	        this.razoncambio = razoncambio;
	    }

	    public String getClasifcambio() {
	        return clasifcambio;
	    }
	    @XmlElement
	    public void setClasifcambio(String clasifcambio) {
	        this.clasifcambio = clasifcambio;
	    }

	    public String getTipocambio() {
	        return tipocambio;
	    }
	    @XmlElement
	    public void setTipocambio(String tipocambio) {
	        this.tipocambio = tipocambio;
	    }

	    public String getLote() {
	        return lote;
	    }
	    @XmlElement
	    public void setLote(String lote) {
	        this.lote = lote;
	    }

	    public String getOp() {
	        return op;
	    }
	    @XmlElement
	    public void setOp(String op) {
	        this.op = op;
	    }

	    public String getTamno() {
	        return tamno;
	    }
	    @XmlElement
	    public void setTamno(String tamno) {
	        this.tamno = tamno;
	    }

	    public String getJustificacion() {
	        return justificacion;
	    }
	    @XmlElement
	    public void setJustificacion(String justificacion) {
	        this.justificacion = justificacion;
	    }

        public DtoEquipo getEquipoRegistro() {
            return equipoRegistro;
        }
        @XmlElement
        public void setEquipoRegistro(DtoEquipo equipoRegistro) {
            this.equipoRegistro = equipoRegistro;
        }
            
    	@Override
    	public String toString() {
    		return "DtoRegistroCambios [Codigo=" + Codigo + ", Aplicado=" + Aplicado + ", cual="
    				+ cual +", solicitado=" + solicitado + ", Area=" + Area + ", prioridad="
    				+ prioridad + ", tipodoc=" + tipodoc + ", otro=" + otro + ", situactual="
    				+ situactual +", situpropuesta=" + situpropuesta + ", razoncambio=" + razoncambio + ", clasifcambio="
    				+ clasifcambio  + ", tipocambio=" + tipocambio + ", lote="
    				+ lote +", op=" + op + ", tamno=" + tamno + ", justificacion="
    				+ justificacion + ", equipoRegistro=" + equipoRegistro + ", Fecha=" + Fecha + ", Fecha2="
    				+ Fecha2  + "]";
    	}    
	    
	}