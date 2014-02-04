package org.kep.cemetery.result;

public class FmpXMLDatabase {
	private String dateFormat;
	private String layout;
	private String name;
	private String records;
	private String timeFormat;
	
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecords() {
		return records;
	}
	public void setRecords(String records) {
		this.records = records;
	}
	public String getTimeFormat() {
		return timeFormat;
	}
	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLDatabase[");
		sb.append("dateFormat=").append(dateFormat).append(", ");
		sb.append("layout=").append(layout).append(", ");
		sb.append("name=").append(name).append(", ");
		sb.append("records=").append(records).append(", ");
		sb.append("timeFormat=").append(timeFormat).append("] ");
		return sb.toString();
	}
}
