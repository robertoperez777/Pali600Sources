package org.kep.cemetery.parser;

import java.util.Stack;

import org.kep.cemetery.result.FmpXMLColumn;
import org.kep.cemetery.result.FmpXMLColumnData;
import org.kep.cemetery.result.FmpXMLDatabase;
import org.kep.cemetery.result.FmpXMLMetaData;
import org.kep.cemetery.result.FmpXMLMetaDataField;
import org.kep.cemetery.result.FmpXMLProduct;
import org.kep.cemetery.result.FmpXMLResult;
import org.kep.cemetery.result.FmpXMLResultSet;
import org.kep.cemetery.result.FmpXMLResultSetRow;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FmpXMLParserHandler extends DefaultHandler {

	private final String UNKNOWN = "unknown";
	private Locator locator;
	private Stack<Object> stack;
	private FmpXMLResult result;
	private boolean isStackReadyForText;

	public FmpXMLParserHandler() {
		stack = new Stack<Object>();
		isStackReadyForText = false;
	}

	@Override
	public void setDocumentLocator(Locator pLocator) {
		locator = pLocator;
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start document parsing ...");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End document parsing ...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		isStackReadyForText = false;
		if (localName.equals("FMPXMLRESULT")) {
			stack.push(new FmpXMLResult());
		} else if (localName.equals("PRODUCT")) {
			stack.push(new FmpXMLProduct());
			String build = resolveAttrib(uri, "BUILD", attributes, UNKNOWN);
			String name = resolveAttrib(uri, "NAME", attributes, UNKNOWN);
			String version = resolveAttrib(uri, "VERSION", attributes, UNKNOWN);
			((FmpXMLProduct) stack.peek()).setBuild(build);
			((FmpXMLProduct) stack.peek()).setName(name);
			((FmpXMLProduct) stack.peek()).setVersion(version);
		} else if (localName.equals("DATABASE")) {
			stack.push(new FmpXMLDatabase());
			String dateFormat = resolveAttrib(uri, "DATEFORMAT", attributes, UNKNOWN);
			String layout = resolveAttrib(uri, "LAYOUT", attributes, UNKNOWN);
			String name = resolveAttrib(uri, "NAME", attributes, UNKNOWN);
			String records = resolveAttrib(uri, "RECORDS", attributes, UNKNOWN);
			String timeFormat = resolveAttrib(uri, "TIMEFORMAT", attributes, UNKNOWN);
			((FmpXMLDatabase) stack.peek()).setDateFormat(dateFormat);
			((FmpXMLDatabase) stack.peek()).setLayout(layout);
			((FmpXMLDatabase) stack.peek()).setName(name);
			((FmpXMLDatabase) stack.peek()).setRecords(records);
			((FmpXMLDatabase) stack.peek()).setTimeFormat(timeFormat);
		} else if (localName.equals("METADATA")) {
			stack.push(new FmpXMLMetaData());
		} else if (localName.equals("FIELD")) {
			stack.push(new FmpXMLMetaDataField());
			String emptyOK = resolveAttrib(uri, "EMPTYOK", attributes, UNKNOWN);
			String maxRepeat = resolveAttrib(uri, "MAXREPEAT", attributes, UNKNOWN);
			String name = resolveAttrib(uri, "NAME", attributes, UNKNOWN);
			String type = resolveAttrib(uri, "TYPE", attributes, UNKNOWN);
			((FmpXMLMetaDataField) stack.peek()).setEmptyOK(emptyOK);
			((FmpXMLMetaDataField) stack.peek()).setMaxRepeat(maxRepeat);
			((FmpXMLMetaDataField) stack.peek()).setName(name);
			((FmpXMLMetaDataField) stack.peek()).setType(type);
		} else if (localName.equals("RESULTSET")) {
			stack.push(new FmpXMLResultSet());
			String found = resolveAttrib(uri, "FOUND", attributes, UNKNOWN);
			((FmpXMLResultSet) stack.peek()).setFound(found);
		} else if (localName.equals("ROW")) {
			stack.push(new FmpXMLResultSetRow());
			String modID = resolveAttrib(uri, "MODID", attributes, UNKNOWN);
			String recordId = resolveAttrib(uri, "RECORDID", attributes, UNKNOWN);
			((FmpXMLResultSetRow) stack.peek()).setModID(modID);
			((FmpXMLResultSetRow) stack.peek()).setRecordId(recordId);
		} else if (localName.equals("COL")) {
			stack.push(new FmpXMLColumn());
		} else if (localName.equals("ERRORCODE") || localName.equals("DATA")) {
			stack.push(new StringBuilder());
			isStackReadyForText = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		isStackReadyForText = false;
		Object tmp = stack.pop();
		if (localName.equals("FMPXMLRESULT")) {
			result = (FmpXMLResult) tmp;
		} else if (localName.equals("PRODUCT")) {
			((FmpXMLResult)stack.peek()).setProduct((FmpXMLProduct) tmp);
		} else if (localName.equals("DATABASE")) {
			((FmpXMLResult)stack.peek()).setDatabase((FmpXMLDatabase) tmp);
		} else if (localName.equals("METADATA")) {
			((FmpXMLResult)stack.peek()).setMetadata((FmpXMLMetaData) tmp);
		} else if (localName.equals("FIELD")) {
			((FmpXMLMetaData)stack.peek()).addToMetaDataFields((FmpXMLMetaDataField) tmp);
		} else if (localName.equals("RESULTSET")) {
			((FmpXMLResult)stack.peek()).setResultSet((FmpXMLResultSet) tmp);
		} else if (localName.equals("ROW")) {
			((FmpXMLResultSet)stack.peek()).addToResultSetRow((FmpXMLResultSetRow) tmp);
		} else if (localName.equals("COL")) {
			((FmpXMLResultSetRow)stack.peek()).addToColumns((FmpXMLColumn) tmp);
		} else if (localName.equals("ERRORCODE")) {
			((FmpXMLResult)stack.peek()).setErrorCode(tmp.toString());
		} else if (localName.equals("DATA")) {
			((FmpXMLColumn) stack.peek()).addToColumnData(new FmpXMLColumnData(tmp.toString()));
		} else {
			stack.push(tmp);
		}
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
