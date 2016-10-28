package co.janker.dto.objresponse;

import com.co.farmatech.metrofarm.dto.PageData;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Respuesta")
public class ObjectResponse {

    private String errorCode;
    private String description;
    private Object obj;
    private ArrayList<?> records;
    private PageData pageResponse;

    public String getErrorCode() {
        return errorCode;
    }

    @XmlElement(name = "CodigoError")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name = "Descripcion")
    public void setDescription(String description) {
        this.description = description;
    }

    public Object getObj() {
        return obj;
    }

    @XmlElement(name = "ObjetoRespuesta")
    public void setObj(Object obj) {
        this.obj = obj;
    }

    public ArrayList<?> getRecords() {
        return records;
    }
    @XmlElement(name = "RegistrosRespuesta")
    public void setRecords(ArrayList<?> records) {
        this.records = records;
    }

	public PageData getpageResponse() {
		return pageResponse;
	}
	@XmlElement(name = "PageRequest")
	public void setpageResponse(PageData pageResponse) {
		this.pageResponse = pageResponse;
	}
	
	@Override
	public String toString() {
		return "ObjectResponse [errorCode=" + errorCode + ", description=" + description + ", obj="
				+ obj +", records=" + records + ", pageResponse=" + pageResponse + "]";
	}
    
    
	
	
	
}
