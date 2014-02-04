package org.kep.cemetery.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.kep.cemetery.result.FmpXMLColumn;
import org.kep.cemetery.result.FmpXMLColumnData;
import org.kep.cemetery.result.FmpXMLMetaDataField;
import org.kep.cemetery.result.FmpXMLResult;
import org.kep.cemetery.result.FmpXMLResultSetRow;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class FmpXMLParser {
	
	private static final String SAMPLE_XML = "src/main/resources/sample.xml";
	private static final String KARTON_ALL_XML = "src/main/resources/karton_all.xml";

	public FmpXMLResult parseFmpXMl() {

		FmpXMLResult result = null;		
		XMLReader rdr;
		try {
			rdr = XMLReaderFactory.createXMLReader();
			rdr.setContentHandler(new FmpXMLParserHandler());
			rdr.parse(KARTON_ALL_XML);		
			FmpXMLParserHandler handler = (FmpXMLParserHandler) rdr.getContentHandler();
			result = handler.getResult();
			postProcessing(result);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private void postProcessing(FmpXMLResult result) {
		Map<Integer, String> metaColumnMap = new HashMap<Integer, String>();
		int metaId = 0;
		for (FmpXMLMetaDataField metaDataField : result.getMetadata().getMetaDataFields()) {
			metaColumnMap.put(++metaId, metaDataField.getName());
		}
		
		for (FmpXMLResultSetRow row : result.getResultSet().getResultSetRow()) {
			int colId = 0;
			for (FmpXMLColumn column : row.getColumns()) {
				column.setColId(++colId);
				int rowId = 0;
				for (FmpXMLColumnData colData : column.getColumnDatas()) {
					colData.setRowId(++rowId);
				}
			}
		}
		
		for (FmpXMLResultSetRow row : result.getResultSet().getResultSetRow()) {
			for (FmpXMLColumn column : row.getColumns()) {
				column.setColumnName(metaColumnMap.get(column.getColId()));
			}
		}
	}
	
}
