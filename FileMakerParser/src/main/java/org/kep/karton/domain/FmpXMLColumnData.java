package org.kep.karton.domain;

public class FmpXMLColumnData {
	
	private int rowId;
	private String data;
	
	public FmpXMLColumnData() {	
	}
	
	public FmpXMLColumnData(String pData) {
		this.data = pData;
	}
	
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
