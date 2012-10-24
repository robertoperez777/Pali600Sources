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
}
