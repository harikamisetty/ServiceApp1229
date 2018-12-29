package com.hari.serviceapp.signin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.serviceapp.signin.beans.SignInRequest;
import com.hari.serviceapp.signin.beans.SignInResponse;
import com.hari.serviceapp.signup.repository.UserAddress;
import com.hari.serviceapp.signup.repository.UserAddressRepository;
import com.hari.serviceapp.signup.repository.UserData;
import com.hari.serviceapp.signup.repository.UserDataRepository;
import com.hari.serviceapp.signup.repository.UserPersonalInfo;
import com.hari.serviceapp.signup.repository.UserPersonalInfoRepository;

@Service
public class SigninServiceImpl {

	@Autowired
	private UserDataRepository userDataRepository;
	@Autowired
	private UserPersonalInfoRepository userPersonalInfoRepository;
	@Autowired
	private UserAddressRepository userAddressRepository;

	public SignInResponse loginUser(SignInRequest signInRequest) {

		SignInResponse signInResponse = new SignInResponse();

		if (null != signInRequest && null != signInRequest.getLoginInfo()) {

			UserData userData = userDataRepository.findByUserName(signInRequest.getLoginInfo().getEmail());
			System.out.println("userId..........." + userData.getUserid());

			Optional<UserPersonalInfo> userPersonalInfo = userPersonalInfoRepository.findById(userData.getUserid());

			if (userPersonalInfo.isPresent()) {
				userPersonalInfo.ifPresent(user -> {
					signInResponse.setFirstName(user.getFirstName());
					signInResponse.setLastName(user.getLastName());
				});
			}

			Optional<UserAddress> userAddress = userAddressRepository.findById(userData.getUserid());
		}
		return signInResponse;
	}
}
