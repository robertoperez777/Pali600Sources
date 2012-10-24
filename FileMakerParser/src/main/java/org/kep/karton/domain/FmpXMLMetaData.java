package org.kep.karton.domain;

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
	
	public void addToMetaDataField(FmpXMLMetaDataField metaDataField) {
		this.metaDataFields.add(metaDataField);
	}
}
