package org.kep.sax.parser;

import java.util.Stack;

import org.kep.karton.domain.FmpXMLResult;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FmpXMLParserHandler extends DefaultHandler {

	private Locator locator;
	private Stack stack;
	private FmpXMLResult result;
	private boolean isStackReadyForText;

	public FmpXMLParserHandler() {
		stack = new Stack();
		isStackReadyForText = false;
	}

	@Override
	public void setDocumentLocator(Locator pLocator) {
		locator = pLocator;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parsing ...");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End parsing ...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (isStackReadyForText == true) {
			((StringBuilder) stack.peek()).append(ch, start, length);
		}
	}

	private String resolveAttrib(String uri, String localName, Attributes attribs, String defaultValue) {
		String tmp = attribs.getValue(localName);
		return (tmp != null) ? (tmp) : (defaultValue);
	}

	public FmpXMLResult getResult() {
		return result;
	}

	public void setResult(FmpXMLResult result) {
		this.result = result;
	}

}
