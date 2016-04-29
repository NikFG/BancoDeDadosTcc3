package com.tcc.util;
import java.io.IOException;
import java.io.StringWriter;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.tcc.domain.*;
public class JAXBUtil {
	private static JAXBContext context;
	private static JAXBUtil instance;
	
	private static JAXBUtil getInstance(){	
		return instance;
	}
	static{
		try{
			context = JAXBContext.newInstance(Response.class, ListaNoticias.class, Noticia.class);
		}catch(JAXBException e){
			throw new RuntimeException(e);
		}
	}
	public static String toXML(Object object) throws IOException{
		StringWriter writer = new StringWriter();
		try {
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(object, writer);
			String xml = writer.toString();
			return xml;
		} catch (JAXBException e) {		
			e.printStackTrace();
			return null;
		}
		
		
	}
	public static String toJson(Object object) throws IOException{
		try{
			StringWriter writer = new StringWriter();
			Marshaller m = context.createMarshaller();
			MappedNamespaceConvention con = new MappedNamespaceConvention();
			XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(con, writer);
			m.marshal(object, xmlStreamWriter);
			String json = writer.toString();
			return json;
		}catch(JAXBException e){
			e.printStackTrace();
			return null;
		}
	}
}
