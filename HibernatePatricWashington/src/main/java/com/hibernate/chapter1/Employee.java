package com.hibernate.chapter1;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "EmployeeInfo")
public class Employee {

	private int empId;
	private String empName;
	private String empPassword;
	private String empEmailAddress;
	private Boolean isPermanent;
	private Calendar empJoinDate;
	private Date empLoginTime;

	@Id
	@TableGenerator(name = "empid", table = "emppktb", pkColumnName = "empKey", pkColumnValue = "empValue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "empid")
	@Column(name = "EmployeeId")
	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Transient
	public String getEmpPassword() {
		return this.empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Column(nullable = false)
	public String getEmpEmailAddress() {
		return this.empEmailAddress;
	}

	public void setEmpEmailAddress(String empEmailAddress) {
		this.empEmailAddress = empEmailAddress;
	}

	@Type(type = "yes_no")
	public boolean isPermanent() {
		return this.isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getEmpJoinDate() {
		return this.empJoinDate;
	}

	public void setEmpJoinDate(Calendar empJoinDate) {
		this.empJoinDate = empJoinDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getEmpLoginTime() {
		return this.empLoginTime;
	}

	public void setEmpLoginTime(Date empLoginTime) {
		this.empLoginTime = empLoginTime;
	}
}
