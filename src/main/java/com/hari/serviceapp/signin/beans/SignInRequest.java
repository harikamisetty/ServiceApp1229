package com.hari.serviceapp.signin.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hari.serviceapp.signup.beans.LoginInfo;

@JsonInclude(Include.NON_NULL)
public class SignInRequest {
	
	private LoginInfo loginInfo;
	
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
}
