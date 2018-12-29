package com.hari.serviceapp.serviceProvider.service;

import com.hari.serviceapp.serviceProvider.bean.ServiceProviderRequest;
import com.hari.serviceapp.serviceProvider.bean.ServiceProviderResponse;

public interface ServiceProviderService {
	
	public ServiceProviderResponse  getServiceProviderDetails(ServiceProviderRequest serviceProviderRequest) ;
	public ServiceProviderResponse postServiceProvidersRequest(ServiceProviderRequest serviceProviderRequest) ;

}
