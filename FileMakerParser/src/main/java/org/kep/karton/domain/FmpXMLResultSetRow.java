package org.kep.karton.domain;

public class FmpXMLResultSetRow {
	private String modID;
	private String recordId;
	private FmpXMLColumn column;
	
	public String getModID() {
		return modID;
	}
	public void setModID(String modID) {
		this.modID = modID;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public FmpXMLColumn getColumn() {
		return column;
	}
	public void setColumn(FmpXMLColumn column) {
		this.column = column;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLResultSetRow[");
		sb.append("modID=").append(modID).append(", ");
		sb.append("recordId=").append(recordId).append(", ");
		sb.append("column=").append(column.toString()).append("] ");
		return sb.toString();
	}
}
