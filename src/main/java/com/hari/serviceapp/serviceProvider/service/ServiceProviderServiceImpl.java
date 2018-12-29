package com.hari.serviceapp.serviceProvider.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.serviceapp.common.util.ServiceAppUtil;
import com.hari.serviceapp.serviceProvider.bean.ServiceDetails;
import com.hari.serviceapp.serviceProvider.bean.ServiceProviderRequest;
import com.hari.serviceapp.serviceProvider.bean.ServiceProviderResponse;
import com.hari.serviceapp.signup.repository.ServiceProviderDataBean;
import com.hari.serviceapp.signup.repository.ServiceProviderRepository;
import com.hari.serviceapp.signup.repository.UserPersonalInfo;
import com.hari.serviceapp.signup.repository.UserPersonalInfoRepository;



@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	@Autowired
	private UserPersonalInfoRepository userPersonalInfoRepository;


	@Override
	public ServiceProviderResponse postServiceProvidersRequest(ServiceProviderRequest serviceProviderRequest) {

		ServiceProviderResponse serviceProviderResponse = null;
		ServiceProviderDataBean serviceProviderDataBean = null;

		if (null != serviceProviderRequest) {
			serviceProviderResponse = new ServiceProviderResponse();
			serviceProviderDataBean = new ServiceProviderDataBean();
			
			String serviceId = ServiceAppUtil.getRequestString();
			serviceProviderResponse.setRequestconfirmationnumber(serviceId);
			serviceProviderDataBean.setServiceid(serviceId);
			serviceProviderDataBean.setServicetype(serviceProviderRequest.getRequestType());
			serviceProviderDataBean.setCity(serviceProviderRequest.getCity());
			serviceProviderDataBean.setState(serviceProviderRequest.getState());
			serviceProviderDataBean.setServicedescription(serviceProviderRequest.getDescription());
			serviceProviderDataBean.setUserid("5C7C5WYH"); //TODO : need to read from context

			serviceProviderRepository.save(serviceProviderDataBean);
		}
		
		
		return serviceProviderResponse;
	}

	@Override
	public ServiceProviderResponse getServiceProviderDetails(ServiceProviderRequest serviceProviderRequest) {
		ServiceProviderResponse serviceProviderResponse = null;

		if (null != serviceProviderRequest) {
			serviceProviderResponse = new ServiceProviderResponse();
			List<ServiceProviderDataBean> serviceProviderDataBeanList = serviceProviderRepository.findAllByServicetype("paiting");
			List<ServiceDetails> serviceDetailsList = new ArrayList<>();
			serviceProviderDataBeanList.forEach(serviceProviderDataBean -> {
				ServiceDetails serviceDetails = new ServiceDetails();
				serviceDetails.setDescription(serviceProviderDataBean.getServicedescription());
				
				Optional<UserPersonalInfo>  userPersonalInfo = userPersonalInfoRepository.findById(serviceProviderDataBean.getUserid());
				
				if (userPersonalInfo.isPresent()) {
						userPersonalInfo.ifPresent(user -> {
						serviceDetails.setFirstname(user.getFirstName());
						serviceDetails.setLastname(user.getLastName());
						serviceDetails.setPhonenumber1(user.getPhoneNumber1());
						serviceDetails.setPhonenumber2(user.getPhoneNumber2());
					});
				}
				serviceDetailsList.add(serviceDetails);
			});
			
			serviceProviderResponse.setServiceDetails(serviceDetailsList);
		}
		return serviceProviderResponse;
	}
}
