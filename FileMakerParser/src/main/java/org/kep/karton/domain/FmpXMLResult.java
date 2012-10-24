package org.kep.karton.domain;


public class FmpXMLResult {
	
	private String errorCode;
	private FmpXMLProduct product;
	private FmpXMLDatabase database;
	private FmpXMLMetaData metadata;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public FmpXMLProduct getProduct() {
		return product;
	}

	public void setProduct(FmpXMLProduct product) {
		this.product = product;
	}

	public FmpXMLDatabase getDatabase() {
		return database;
	}

	public void setDatabase(FmpXMLDatabase database) {
		this.database = database;
	}

	public FmpXMLMetaData getMetadata() {
		return metadata;
	}

	public void setMetadata(FmpXMLMetaData metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FmpXMLResult[");
		sb.append("errorCode=").append(errorCode).append(", ");
		sb.append("product=").append(product.toString()).append(", ");
		sb.append("database=").append(database.toString()).append(", ");
		sb.append("metadata=").append(metadata.toString()).append(", ");
		sb.append("] ");
		return sb.toString();
	}
	
}
