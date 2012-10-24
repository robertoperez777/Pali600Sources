package org.kep.karton.domain;

import java.util.ArrayList;
import java.util.List;

public class FmpXMLResult {
	
	private String errorCode;
	private String product;
	private List<FmpXMLProduct> products;
	
	public FmpXMLResult() {
		products = new ArrayList<FmpXMLProduct>();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public List<FmpXMLProduct> getProducts() {
		return products;
	}

	public void setProducts(List<FmpXMLProduct> products) {
		this.products = products;
	}
	
	public void addToProducts(FmpXMLProduct product) {
		this.products.add(product);
	}
	
}
