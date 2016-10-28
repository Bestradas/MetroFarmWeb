package co.jankins.psf.common.conversion;

import co.jankins.psf.common.exception.JankinsMarshallException;
/**
 * 
 * @author Bestrada
 *
 */
public interface MarshallService {

	/**
	 * 
	 * @param object -- Objeto a convertir a xml
	 * @param c		 -- Listado de clases que contiene el objeto y el objeto
	 * @return		 -- String con el xml del objeto
	 */
	public String marshallObject(Object object,Class... c);

	/**
	 * 
	 * @param Xml -- Xml con el objeto
	 * @return    -- Objeto que obtengo del xml
	 * @throws JankinsMarshallException
	 */
	public Object unmarshallXml(String Xml, Class... c) throws JankinsMarshallException;

}
