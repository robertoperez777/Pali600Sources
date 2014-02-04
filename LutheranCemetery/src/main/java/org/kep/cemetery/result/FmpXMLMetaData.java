package org.kep.cemetery.result;

import java.util.ArrayList;
import java.util.List;

public class FmpXMLMetaData {
	
	private List<FmpXMLMetaDataField> metaDataFields;
	
	public FmpXMLMetaData() {
		metaDataFields = new ArrayList<FmpXMLMetaDataField>();
	}

	public List<FmpXMLMetaDataField> getMetaDataFields() {
		return metaDataFields;
	}

	public void setMetaDataFields(List<FmpXMLMetaDataField> metaDataFields) {
		this.metaDataFields = metaDataFields;
	}
	
	public void addToMetaDataFields(FmpXMLMetaDataField metaDataField) {
		this.metaDataFields.add(metaDataField);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLMetaDataField[");
		for (FmpXMLMetaDataField dataField : metaDataFields) {
			sb.append(dataField.toString());
			sb.append(" ");
		}
		sb.append("] ");
		return sb.toString();
	}
}
