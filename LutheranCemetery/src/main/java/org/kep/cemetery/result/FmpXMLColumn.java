package org.kep.cemetery.result;

import java.util.ArrayList;
import java.util.List;

public class FmpXMLColumn {
	
	private int colId;
	private String columnName;
	private List<FmpXMLColumnData> columnDatas;
	
	public FmpXMLColumn() {
		columnDatas = new ArrayList<FmpXMLColumnData>();
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
	public List<FmpXMLColumnData> getColumnDatas() {
		return columnDatas;
	}
	public void setColumnDatas(List<FmpXMLColumnData> columnDatas) {
		this.columnDatas = columnDatas;
	}
	public void addToColumnData(FmpXMLColumnData pColumnData){
		this.columnDatas.add(pColumnData);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLColumn[");
		sb.append("colId=").append(colId).append(", ");
		sb.append("columnName=").append(columnName).append(", ");
		sb.append("FmpXMLColumnData[ ");
		for (FmpXMLColumnData colData : columnDatas) {
			sb.append(colData.toString());
			sb.append(" ");
		}
		sb.append("] ");
		return sb.toString();
	}
}
