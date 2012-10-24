package org.kep.karton.domain;

public class FmpXMLMetaDataField {
	private String emptyOK;
	private String maxRepeat;
	private String name;
	private String type;
	
	public String getEmptyOK() {
		return emptyOK;
	}
	public void setEmptyOK(String emptyOK) {
		this.emptyOK = emptyOK;
	}
	public String getMaxRepeat() {
		return maxRepeat;
	}
	public void setMaxRepeat(String maxRepeat) {
		this.maxRepeat = maxRepeat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLMetaDataField[");
		sb.append("emptyOK=").append(emptyOK).append(", ");
		sb.append("maxRepeat=").append(maxRepeat).append(", ");
		sb.append("name=").append(name).append(", ");
		sb.append("type=").append(type).append("] ");
		return sb.toString();
	}
	
}
