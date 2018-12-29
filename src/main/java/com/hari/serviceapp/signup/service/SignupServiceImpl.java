package com.hari.serviceapp.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.serviceapp.common.util.ServiceAppUtil;
import com.hari.serviceapp.signup.repository.UserAddress;
import com.hari.serviceapp.signup.repository.UserAddressRepository;
import com.hari.serviceapp.signup.repository.UserData;
import com.hari.serviceapp.signup.repository.UserDataRepository;
import com.hari.serviceapp.signup.repository.UserPersonalInfo;
import com.hari.serviceapp.signup.repository.UserPersonalInfoRepository;
import com.hari.serviceapp.signup.request.bean.SignUpRequest;

@Service
public class SignupServiceImpl {

	@Autowired
	private UserDataRepository userDataRepository;
	@Autowired
	private UserPersonalInfoRepository userPersonalInfoRepository;
	@Autowired
	private UserAddressRepository userAddressRepository;

	public boolean RegisterUser(SignUpRequest signUpRequest) {
		String randomUserId = ServiceAppUtil.getRandonString();
		if (null != signUpRequest && null != signUpRequest.getLoginInfo()) {
			UserData userdata = new UserData();
			userdata.setUserid(randomUserId);
			userdata.setUserName(signUpRequest.getLoginInfo().getEmail());
			userdata.setPassword(signUpRequest.getLoginInfo().getEmail());
			userdata.setConfirmPassword(signUpRequest.getLoginInfo().getConfirmPassword());
			userdata.setRegisterDate(ServiceAppUtil.getDateAsString());
			userdata.setLastLoginDate(ServiceAppUtil.getDateAsString());
			if (null != signUpRequest.getLoginInfo().getRequestType()
					&& signUpRequest.getLoginInfo().getRequestType().equalsIgnoreCase("both")) {
				userdata.setService_requester(true);
				userdata.setService_provider(true);
			}

			if (null != signUpRequest.getLoginInfo().getRequestType()
					&& signUpRequest.getLoginInfo().getRequestType().equalsIgnoreCase("requester")) {
				userdata.setService_requester(true);
			}

			if (null != signUpRequest.getLoginInfo().getRequestType()
					&& signUpRequest.getLoginInfo().getRequestType().equalsIgnoreCase("provider")) {
				userdata.setService_provider(true);
			}

			userDataRepository.save(userdata);
		}
		
		if (null != signUpRequest && null != signUpRequest.getPersonalInfo()) {
			
			UserPersonalInfo userPersonalInfo = new UserPersonalInfo();
			
			userPersonalInfo.setUserid(randomUserId);
			userPersonalInfo.setFirstName(signUpRequest.getPersonalInfo().getFirstName());
			userPersonalInfo.setLastName(signUpRequest.getPersonalInfo().getLastName());
			userPersonalInfo.setEmail(signUpRequest.getLoginInfo().getEmail());
			userPersonalInfo.setDob(signUpRequest.getPersonalInfo().getDob());
			userPersonalInfo.setPhoneNumber1(signUpRequest.getPersonalInfo().getPhoneNumber1());
			userPersonalInfo.setPhoneNumber2(signUpRequest.getPersonalInfo().getPhoneNumber2());
			
			userPersonalInfoRepository.save(userPersonalInfo);
		}
		
		if (null != signUpRequest && null != signUpRequest.getAddressInfo()) {
			
			UserAddress userAddress = new UserAddress (); 
			
			userAddress.setUserid(randomUserId);
			userAddress.setAddressId(ServiceAppUtil.getAddressid());
			userAddress.setAddressLine1(signUpRequest.getAddressInfo().getAddressLine1());
			userAddress.setAddressLine2(signUpRequest.getAddressInfo().getAddressLine2());
			userAddress.setLandmark(signUpRequest.getAddressInfo().getLandmark());
			userAddress.setLocality(signUpRequest.getAddressInfo().getLocality());
			userAddress.setCity(signUpRequest.getAddressInfo().getCity());
			userAddress.setState(signUpRequest.getAddressInfo().getState());
			userAddress.setPincode(signUpRequest.getAddressInfo().getPincode());
			
			userAddressRepository.save(userAddress);
		}
		return true;
	}

	public UserPersonalInfoRepository getUserPersonalInfoRepository() {
		return userPersonalInfoRepository;
	}

	public void setUserPersonalInfoRepository(UserPersonalInfoRepository userPersonalInfoRepository) {
		this.userPersonalInfoRepository = userPersonalInfoRepository;
	}

	public UserAddressRepository getUserAddressRepository() {
		return userAddressRepository;
	}

	public void setUserAddressRepository(UserAddressRepository userAddressRepository) {
		this.userAddressRepository = userAddressRepository;
	}

	public UserDataRepository getUserDataRepository() {
		return userDataRepository;
	}

	public void setUserDataRepository(UserDataRepository userDataRepository) {
		this.userDataRepository = userDataRepository;
	}

}
