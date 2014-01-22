package com.hibernate.chapter3;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;

@Embeddable
public class SchoolDetail {

	private String schoolAddress;
	private boolean isPublicSchool;
	private int studentCount;

	public String getSchoolAddress() {
		return this.schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	@Type(type = "yes_no")
	public boolean isPublicSchool() {
		return this.isPublicSchool;
	}

	public void setPublicSchool(boolean isPublicSchool) {
		this.isPublicSchool = isPublicSchool;
	}

	public int getStudentCount() {
		return this.studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

}
