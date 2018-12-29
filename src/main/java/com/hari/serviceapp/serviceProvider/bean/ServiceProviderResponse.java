package com.hari.serviceapp.serviceProvider.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hari.serviceapp.signup.repository.ServiceProviderDataBean;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceProviderResponse {
	
	private List<ServiceDetails> serviceDetails;
	private String requestconfirmationnumber;
	private List<ServiceProviderDataBean> serviceProviderDataBeanList;

	public List<ServiceDetails> getServiceDetails() {
		return serviceDetails;
	}

	public void setServiceDetails(List<ServiceDetails> serviceDetails) {
		this.serviceDetails = serviceDetails;
	}

	public String getRequestconfirmationnumber() {
		return requestconfirmationnumber;
	}

	public void setRequestconfirmationnumber(String requestconfirmationnumber) {
		this.requestconfirmationnumber = requestconfirmationnumber;
	}

	public List<ServiceProviderDataBean> getServiceProviderDataBeanList() {
		return serviceProviderDataBeanList;
	}

	public void setServiceProviderDataBeanList(List<ServiceProviderDataBean> serviceProviderDataBeanList) {
		this.serviceProviderDataBeanList = serviceProviderDataBeanList;
	}

}
