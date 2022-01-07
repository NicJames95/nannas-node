package com.Nannas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	

	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
