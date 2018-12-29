package com.hari.serviceapp.signin.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hari.serviceapp.beans.ResponseEntity;
import com.hari.serviceapp.beans.ServiceResponse;
import com.hari.serviceapp.common.service.JsonService;
import com.hari.serviceapp.signin.beans.SignInRequest;
import com.hari.serviceapp.signin.beans.SignInResponse;
import com.hari.serviceapp.signin.service.SigninServiceImpl;

@RestController
@RequestMapping(value = "/serviceapp")
public class SigninRestServiceImpl {

	@Autowired
	private SigninServiceImpl signinServiceImpl;

	@PostMapping(path = "/signin", consumes = "application/json", produces = "application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<ServiceResponse> signUser(@RequestBody SignInRequest signInRequest) {

		ResponseEntity<ServiceResponse> resource = null;
		SignInResponse signInResponse = null;

		ServiceResponse serviceResponse = new ServiceResponse();
		if (null != signInRequest && null != signInRequest.getLoginInfo()) {
			signInResponse = signinServiceImpl.loginUser(signInRequest);
			serviceResponse.setStatus("SUCCESS");
			serviceResponse.setPayload(
					JsonService.getObjectFromJson(JsonService.getJsonFromObject(signInResponse), JsonNode.class));
			resource = new ResponseEntity<>(serviceResponse);
			resource.setStatusCode(200);
		} else {

			serviceResponse.setStatus("FAILURE");
			resource = new ResponseEntity<>(serviceResponse);
			resource.setStatusCode(400);
		}
		return resource;
	}
}
