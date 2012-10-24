package org.kep.karton.domain;

import java.util.ArrayList;
import java.util.List;

public class FmpXMLResultSetRow {
	private String modID;
	private String recordId;
	private List<FmpXMLColumn> columns;
	
	public FmpXMLResultSetRow() {
		columns = new ArrayList<FmpXMLColumn>();
	}
	
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
	public List<FmpXMLColumn> getColumns() {
		return columns;
	}
	public void setColumns(List<FmpXMLColumn> columns) {
		this.columns = columns;
	}
	public void addToColumns(FmpXMLColumn columns) {
		this.columns.add(columns);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLResultSetRow[");
		sb.append("modID=").append(modID).append(", ");
		sb.append("recordId=").append(recordId).append(", ");
		for (FmpXMLColumn column : columns) {
			sb.append(column.toString());
			sb.append(" ");
		}
		sb.append("] ");
		return sb.toString();
	}
	
}
