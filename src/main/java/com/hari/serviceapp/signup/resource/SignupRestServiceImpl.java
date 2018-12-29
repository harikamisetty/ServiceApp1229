package com.hari.serviceapp.signup.resource;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.hari.serviceapp.beans.ResponseEntity;
import com.hari.serviceapp.beans.ServiceResponse;
import com.hari.serviceapp.common.service.JsonService;
import com.hari.serviceapp.signup.request.bean.SignUpRequest;
import com.hari.serviceapp.signup.request.bean.SignUpResponse;
import com.hari.serviceapp.signup.service.SignupServiceImpl;

@RestController
@RequestMapping(value = "/serviceapp")
public class SignupRestServiceImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupRestServiceImpl.class);

	@Autowired
	private SignupServiceImpl signupService;
	
	@PostMapping(path = "/signup", consumes = "application/json", produces = "application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ServiceResponse> registerCustomer(@RequestBody SignUpRequest signUpRequest) {
		LOGGER.info("Inside registerCustomer");
		
		ResponseEntity<ServiceResponse> resource = null;
		ServiceResponse serviceResponse = new ServiceResponse();
		SignUpResponse signUpResponse = new SignUpResponse(); 
		signUpResponse.setUserid("user1001");
		//serviceClass to register User
		signupService.RegisterUser(signUpRequest);
		
		serviceResponse.setPayload(JsonService.getObjectFromJson(JsonService.getJsonFromObject(signUpResponse),JsonNode.class));
		serviceResponse.setStatus("SUCCESS");
		resource = new ResponseEntity<>(serviceResponse);		
		resource.setStatusCode(200);
		LOGGER.info("Exit registerCustomer");
		return resource;
	}

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Java Code Geeks!";
	}
}
