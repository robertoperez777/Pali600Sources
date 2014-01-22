package com.hibernate.inheritancemapping;

import javax.persistence.Entity;

@Entity
public class Module extends Project {

	private String moduleName;

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

}
