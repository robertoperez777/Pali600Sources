package org.kep.karton.domain;

import java.util.ArrayList;
import java.util.List;

public class FmpXMLResultSet {

	private String found;
	private List<FmpXMLResultSetRow> resultSetRow;

	public FmpXMLResultSet() {
		resultSetRow = new ArrayList<FmpXMLResultSetRow>();
	}

	public String getFound() {
		return found;
	}

	public void setFound(String found) {
		this.found = found;
	}

	public List<FmpXMLResultSetRow> getResultSetRow() {
		return resultSetRow;
	}

	public void setResultSetRow(List<FmpXMLResultSetRow> resultSetRow) {
		this.resultSetRow = resultSetRow;
	}
	
	public void addToResultSetRow(FmpXMLResultSetRow resultSetRow) {
		this.resultSetRow.add(resultSetRow);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLResultSet[");
		sb.append("found=").append(found).append(", ");
		for (FmpXMLResultSetRow result : resultSetRow) {
			sb.append(result.toString());
			sb.append(" ");
		}
		sb.append("] ");
		return sb.toString();
	}

}
