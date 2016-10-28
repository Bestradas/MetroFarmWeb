package co.janker.dto.objsend;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.co.farmatech.metrofarm.dto.PageData;

import co.janker.dto.context.Context;

@XmlRootElement(name = "Envio")
public class ObjectSend {

    private String service;
    private String operation;
    private Object obj;
    private ArrayList<?> records;
    private Context contexto;
    private PageData pageData;
    
    
    public String getService() {
        return service;
    }

    @XmlElement(name = "Servicio")
    public void setService(String service) {
        this.service = service;
    }

    public String getOperation() {
        return operation;
    }

    @XmlElement(name = "Operacion")
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getObj() {
        return obj;
    }

    @XmlElement(name = "ObjetoEnvio")
    public void setObj(Object obj) {
        this.obj = obj;
    }

    public ArrayList<?> getRecords() {
        return records;
    }

    @XmlElement(name = "RegistrosEnvio")
    public void setRecords(ArrayList<?> records) {
        this.records = records;
    }

	public Context getContexto() {
		return contexto;
	}
	@XmlElement(name="Contexto")
	public void setContexto(Context contexto) {
		this.contexto = contexto;
	}

	public PageData getPageData() {
		return pageData;
	}
	@XmlElement(name="PageData")
	public void setPageData(PageData pageData) {
		this.pageData = pageData;
	}
	
	@Override
	public String toString() {
		return "ObjectSend [service=" + service + ", operation=" + operation + ", obj="
				+ obj +", records=" + records + ", contexto=" + contexto + ", pageData="
				+ pageData + "]";
	}
	
    
	

}
