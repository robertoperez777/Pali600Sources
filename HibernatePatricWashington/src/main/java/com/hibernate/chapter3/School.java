package com.hibernate.chapter3;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class School {

	private int schoolId;
	private String schoolName;
	private SchoolDetail schoolDetail;

	@Id
	@GeneratedValue
	public int getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Embedded
	public SchoolDetail getSchoolDetail() {
		return this.schoolDetail;
	}

	public void setSchoolDetail(SchoolDetail schoolDetail) {
		this.schoolDetail = schoolDetail;
	}
}
