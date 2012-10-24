package org.kep.karton.domain;

import java.util.List;

public class FmpXMLResultSet {

	private String found;
	private List<FmpXMLResultSet> resultSet;

	public FmpXMLResultSet() {
	}

	public String getFound() {
		return found;
	}

	public void setFound(String found) {
		this.found = found;
	}

	public List<FmpXMLResultSet> getResultSet() {
		return resultSet;
	}

	public void setResultSet(List<FmpXMLResultSet> resultSet) {
		this.resultSet = resultSet;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLResultSet[");
		sb.append("found=").append(found).append(", ");
		for (FmpXMLResultSet result : resultSet) {
			sb.append(result.toString());
			sb.append(" ");
		}
		sb.append("] ");
		return sb.toString();
	}

}
