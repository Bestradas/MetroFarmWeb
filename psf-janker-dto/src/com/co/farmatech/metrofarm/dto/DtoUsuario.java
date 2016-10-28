package com.co.farmatech.metrofarm.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Usuario")
public class DtoUsuario {

    private String Codigo, Nombres, Telefono1, Celular, Identificacion, Apellidos, Telefono2, Correo, Usuario, Contrasena, Pregunta, Respuesta;
    private Long IdPerfil,Tipo,Estado;
    private DtoPerfil perfil; 
    
    public String getCodigo() {
        return Codigo;
    }
    @XmlElement(name="CodigoUsuario")
    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public Long getTipo() {
        return Tipo;
    }
    @XmlElement(name="TipoDoc")
    public void setTipo(Long Tipo) {
        this.Tipo = Tipo;
    }

    public String getNombres() {
        return Nombres;
    }
    @XmlElement(name="NombreUsuario")
    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getTelefono1() {
        return Telefono1;
    }
    @XmlElement(name="TelefonoUno")
    public void setTelefono1(String Telefono1) {
        this.Telefono1 = Telefono1;
    }

    public String getCelular() {
        return Celular;
    }
    @XmlElement(name="Celular")
    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getIdentificacion() {
        return Identificacion;
    }
    @XmlElement(name="IdUsuario")
    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getApellidos() {
        return Apellidos;
    }
    @XmlElement(name="Apellidos")
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelefono2() {
        return Telefono2;
    }
    @XmlElement(name="TelefonoDos")
    public void setTelefono2(String Telefono2) {
        this.Telefono2 = Telefono2;
    }

    public String getCorreo() {
        return Correo;
    }
    @XmlElement(name="CorreoElectronico")
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getUsuario() {
        return Usuario;
    }
    @XmlElement(name="Usuario")
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }
    @XmlElement(name="Contrasena")
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public Long getIdPerfil() {
        return IdPerfil;
    }
    @XmlElement(name="IdPerfil")
    public void setIdPerfil(Long IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public String getPregunta() {
        return Pregunta;
    }
    @XmlElement(name="PreguntaSeguridad")
    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    public String getRespuesta() {
        return Respuesta;
    }
    @XmlElement(name="RespuestaSeguridad")
    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }
	public DtoPerfil getPerfil() {
		return perfil;
	}
	@XmlElement(name="Perfil")
	public void setPerfil(DtoPerfil perfil) {
		this.perfil = perfil;
	}
	public Long getEstado() {
		return Estado;
	}
	@XmlElement(name="Estado")
	public void setEstado(Long estado) {
		Estado = estado;
	}
	
	@Override
	public String toString() {
		 return "DtoUsuario [Codigo=" + Codigo + ", Nombres=" + Nombres + ", Telefono1="
					+ Telefono1 +", Celular=" + Celular + ", Identificacion=" + Identificacion + ", Apellidos="
					+ Apellidos +", Telefono2=" + Telefono2 + ", Correo=" + Correo + ", Usuario="+ Usuario 
					+", Contrasena=" + Contrasena + ", Pregunta=" + Pregunta + ", Respuesta="
					+ Respuesta +", IdPerfil=" + IdPerfil + ", Tipo=" + Tipo + ", Estado=" + Estado + ", perfil="+ perfil + "]";
	}
	
    
    
}
