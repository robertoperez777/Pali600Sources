package org.javabrains.koushik.dto.Lesson02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
