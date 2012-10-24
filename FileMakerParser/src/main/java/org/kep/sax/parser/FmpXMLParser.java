package org.kep.sax.parser;

import java.io.IOException;

import org.kep.karton.domain.FmpXMLResult;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class FmpXMLParser {
	
	private static final String SAMPLE_XML = "/src/main/resources/sample.xml";
	private static final String KARTON_ALL_XML = "/src/main/resources/karton_all.xml";

	public FmpXMLResult parseFmpXMl() {

		FmpXMLResult result = null;		
		XMLReader rdr;
		try {
			rdr = XMLReaderFactory.createXMLReader();
			rdr.setContentHandler(new FmpXMLParserHandler());
			rdr.parse(SAMPLE_XML);		
			FmpXMLParserHandler handler = (FmpXMLParserHandler) rdr.getContentHandler();
			result = handler.getResult();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
