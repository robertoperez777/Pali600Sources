package org.kep.karton.domain;

import java.util.ArrayList;
import java.util.List;

public class FmpXMLColumn {
	
	private int colId;
	private String columnName;
	private List<FmpXMLColumnData> columnData;
	
	public FmpXMLColumn() {
		columnData = new ArrayList<FmpXMLColumnData>();
	}
	
	public int getColId() {
		return colId;
	}
	public void setColId(int colId) {
		this.colId = colId;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public List<FmpXMLColumnData> getColumnData() {
		return columnData;
	}
	public void setColumnData(List<FmpXMLColumnData> columnData) {
		this.columnData = columnData;
	}
	public void addToColumnData(FmpXMLColumnData pColumnData){
		this.columnData.add(pColumnData);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLColumn[");
		sb.append("colId=").append(colId);
		sb.append("columnName=").append("columnName").append(", ");
		sb.append("FmpXMLColumnData[ ");
		for (FmpXMLColumnData colData : columnData) {
			sb.append(colData.toString());
			sb.append(" ");
		}
		sb.append("] ");
		return sb.toString();
	}
}
