package com.hibernate.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {

	private int collegeId;
	private String collegeName;
	private List<Student> students;

	@Id
	@GeneratedValue
	public int getCollegeId() {
		return this.collegeId;
	}

	public String getCollegeName() {
		return this.collegeName;
	}

	@OneToMany(targetEntity = Student.class, mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Student> getStudents() {
		return this.students;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
