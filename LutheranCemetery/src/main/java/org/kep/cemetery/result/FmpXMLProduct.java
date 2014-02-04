package org.kep.cemetery.result;

public class FmpXMLProduct {
	private String build;
	private String name;
	private String version;
	
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLProduct[");
		sb.append("build=").append(build).append(", ");
		sb.append("name=").append(name).append(", ");
		sb.append("version=").append(version).append("] ");
		return sb.toString();
	}
}
