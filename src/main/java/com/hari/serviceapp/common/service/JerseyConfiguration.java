package com.hari.serviceapp.common.service;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.base.JsonMappingExceptionMapper;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.base.JsonParseExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hari.serviceapp.signup.resource.SignupRestServiceImpl;

/*
@Component
@ApplicationPath("/") */
public class JerseyConfiguration extends ResourceConfig {
	
	@Bean
	@Primary
	public ObjectMapper objectMapper() {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
		objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		return objectMapper;
	}
	
	@Bean
	public Client jercyClient() {
		return ClientBuilder.newClient(new ClientConfig());
	}
	
	@PostConstruct
	public void init() {
		
		register(SignupRestServiceImpl.class);	
		register(JsonParseExceptionMapper.class);
		register(JsonMappingExceptionMapper.class);
		property(ServletProperties.FILTER_FORWARD_ON_404, false);
		
	}

}
