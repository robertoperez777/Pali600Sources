package org.kep.cemetery.parser;

import junit.framework.Assert;

import org.junit.Test;
import org.kep.cemetery.result.FmpXMLColumn;
import org.kep.cemetery.result.FmpXMLColumnData;
import org.kep.cemetery.result.FmpXMLResult;

public class FmpXMLParserTest {

	@Test
	public void testParseFmpXMl() {
		FmpXMLParser parser = new FmpXMLParser();
		FmpXMLResult result = parser.parseFmpXMl();
		Assert.assertNotNull(result);
		System.out.println("Result Set Rows: " + result.getResultSet().getResultSetRow().size());
		printFirstResult(result);
	}

	private void printFirstResult(FmpXMLResult result) {
		for (FmpXMLColumn column : result.getResultSet().getResultSetRow().get(1).getColumns()) {
			System.out.println();
			System.out.println("************************************************************");
			System.out.print("ColID: " + column.getColId());
			System.out.print(" | ");
			System.out.print("ColumnName: " + column.getColumnName());
			System.out.println();
			System.out.println("************************************************************");			
			for(FmpXMLColumnData columnData :column.getColumnDatas()){
				if(!isEmpty(columnData.getData())) {
					System.out.print("RowId: " + columnData.getRowId());
					System.out.print(" | ");
					System.out.print("Data: " + columnData.getData());
					System.out.println();					
				}
			}
		}
	}
	
	private boolean isEmpty(String data) {
		if(data == null || data.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
