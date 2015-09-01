package com.braffa.sellem.webservices.admin.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	//@NotEmpty
	@Size(min = 5, max = 20)
	private String userName;

	//@NotEmpty(message = "Password must not be blank.")
	@Size(min = 4, max = 10, message = "Password must between 6 to 10 Characters.")
	private String password;
	
	private String authorityLevel;
	
	private Date crDate;
	
	private Date updDate;


	public String getAuthorityLevel() {
		return authorityLevel;
	}

	public void setAuthorityLevel(String authorityLevel) {
		this.authorityLevel = authorityLevel;
	}

	public void setUserName(String userName) {

		this.userName = userName;

	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Date getCrDate() {
		return crDate;
	}

	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}


}