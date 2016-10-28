package co.jankins.psf.common.conversion;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;

import co.jankins.psf.common.exception.JankinsMarshallException;

/**
 * 
 * @author Bestrada
 *
 */
public class MarshallServiceImpl implements MarshallService{



	@Override
	public String marshallObject(Object object, Class... c) {
		// TODO Auto-generated method stub
		JAXBContext jc=null;
		Marshaller m=null;
		String xmlOutput="";
		//Marshall Object
		try {
			jc=JAXBContext.newInstance(c);
			m=jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
//			m.setProperty(Marshaller.JAXB_ENCODING, "Windows-1250"); 
			StringWriter writer=new StringWriter();
			m.marshal(object, writer);
			xmlOutput=writer.toString();
			writer.close();
			writer=null;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}finally{

		}

		return xmlOutput;
	}

	@Override
	public Object unmarshallXml(String Xml, Class... c) throws JankinsMarshallException {
		// TODO Auto-generated method stub
		JAXBContext jc=null;
		Unmarshaller um=null;
		Object object=null;

		//UnMarshall Object
		try {
			jc=JAXBContext.newInstance(c);
			um=jc.createUnmarshaller();
			InputStream is = IOUtils.toInputStream(Xml, "UTF-8");
			object = um.unmarshal(is);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JankinsMarshallException(e);
		}


		return object;
	}

}
