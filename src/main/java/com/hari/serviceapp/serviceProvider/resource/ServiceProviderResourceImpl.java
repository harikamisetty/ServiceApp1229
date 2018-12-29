package com.hari.serviceapp.serviceProvider.resource;

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
import com.hari.serviceapp.serviceProvider.bean.ServiceProviderRequest;
import com.hari.serviceapp.serviceProvider.bean.ServiceProviderResponse;
import com.hari.serviceapp.serviceProvider.service.ServiceProviderService;

@RestController
@RequestMapping(value = "/serviceapp")
public class ServiceProviderResourceImpl {

	
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	@PostMapping(path = "/servicerequest", consumes = "application/json", produces = "application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<ServiceResponse> postServiceProvidersRequest(@RequestBody ServiceProviderRequest serviceProviderRequest) {
		
		ResponseEntity<ServiceResponse> response = null;
		ServiceResponse serviceResponse = new ServiceResponse();
		
		if(null!= serviceProviderRequest) {
			
			ServiceProviderResponse serviceProviderResponse =serviceProviderService.postServiceProvidersRequest(serviceProviderRequest);
			
			serviceResponse.setStatus("SUCCESS");
			serviceResponse.setPayload(
					JsonService.getObjectFromJson(JsonService.getJsonFromObject(serviceProviderResponse), JsonNode.class));
			response = new ResponseEntity<>(serviceResponse);
			response.setStatusCode(200);			
		}
		return response;
	}
	
	@PostMapping(path = "/serviceprovider", consumes = "application/json", produces = "application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<ServiceResponse> getServiceProvidersForAService(@RequestBody ServiceProviderRequest serviceProviderRequest) {
		
		ResponseEntity<ServiceResponse> response = null;
		ServiceResponse serviceResponse = new ServiceResponse();
		
		if(null!= serviceProviderRequest) {
			
			ServiceProviderResponse serviceProviderResponse =serviceProviderService.getServiceProviderDetails(serviceProviderRequest);
			
			serviceResponse.setStatus("SUCCESS");
			serviceResponse.setPayload(
					JsonService.getObjectFromJson(JsonService.getJsonFromObject(serviceProviderResponse), JsonNode.class));
			response = new ResponseEntity<>(serviceResponse);
			response.setStatusCode(200);			
		}
		return response;
	}

}
