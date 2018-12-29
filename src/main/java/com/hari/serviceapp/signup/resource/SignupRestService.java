package com.hari.serviceapp.signup.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hari.serviceapp.signup.request.bean.SignUpRequest;

public interface SignupRestService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerCustomer(SignUpRequest signUpRequest);

}
