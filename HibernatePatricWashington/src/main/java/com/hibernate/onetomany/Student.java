package com.hibernate.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	private int studentId;
	private String studentName;
	private College college;

	@Id
	@GeneratedValue
	public int getStudentId() {
		return this.studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	@ManyToOne
	@JoinColumn(name = "collegeId")
	public College getCollege() {
		return this.college;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setCollege(College college) {
		this.college = college;
	}

}
