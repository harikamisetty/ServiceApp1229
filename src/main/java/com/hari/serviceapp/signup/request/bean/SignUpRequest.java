package com.hari.serviceapp.signup.request.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hari.serviceapp.signup.beans.AddressInfo;
import com.hari.serviceapp.signup.beans.LoginInfo;
import com.hari.serviceapp.signup.beans.PersonalInfo;

@JsonInclude(Include.NON_NULL)
public class SignUpRequest {
	
	private LoginInfo loginInfo;
	private PersonalInfo personalInfo;
	private AddressInfo addressInfo;
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	public AddressInfo getAddressInfo() {
		return addressInfo;
	}
	public void setAddressInfo(AddressInfo addressInfo) {
		this.addressInfo = addressInfo;
	}

}
