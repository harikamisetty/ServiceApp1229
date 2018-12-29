package com.hari.serviceapp.common.service;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public final class JsonService {

	private static final ObjectMapper MAPPER;

	private JsonService() {

	}

	static {
		MAPPER = new ObjectMapper();
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		MAPPER.setSerializationInclusion(Include.NON_NULL);
	}
	
	public static String getJsonFromObject(final Object object) {
		String jsonString = null;
		
		try {
			jsonString = MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException jpe) {
			// TODO Auto-generated catch block
			jpe.printStackTrace();
		}
		
		return jsonString;
	}
	
	public static <T> T getObjectFromJson(final Object jsonString, final Class<T> valueType) {
		T object = null;
		
		try {
			object = MAPPER.readValue(jsonString.toString(), valueType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return object;
	}
}
