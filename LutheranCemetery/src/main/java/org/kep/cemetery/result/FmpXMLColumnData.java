package org.kep.cemetery.result;

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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLColumnData[");
		sb.append("rowId=").append(rowId).append(", ");
		sb.append("data=").append(data).append("] ");
		return sb.toString();
	}
}
