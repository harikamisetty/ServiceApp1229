package com.hari.serviceapp.signup.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user_data")
@EntityListeners(AuditingEntityListener.class)
public class UserData {
	
	@Id
	@Column(name="userid")
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userid;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="confirmpassword")
	private String confirmPassword;
	@Column(name="registerdate")
	private String registerDate;
	
	@Column(name="lastlogindate")
	private String lastLoginDate;
	@Column(name="useradmin")
	private boolean user_admin;
	@Column(name="servicerequester")
	private boolean service_requester;
	@Column(name="serviceprovider")
	private boolean service_provider;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public boolean isUser_admin() {
		return user_admin;
	}
	public void setUser_admin(boolean user_admin) {
		this.user_admin = user_admin;
	}
	public boolean isService_requester() {
		return service_requester;
	}
	public void setService_requester(boolean service_requester) {
		this.service_requester = service_requester;
	}
	public boolean isService_provider() {
		return service_provider;
	}
	public void setService_provider(boolean service_provider) {
		this.service_provider = service_provider;
	}
}
