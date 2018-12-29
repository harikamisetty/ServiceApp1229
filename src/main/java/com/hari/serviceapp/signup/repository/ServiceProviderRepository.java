package com.hari.serviceapp.signup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProviderDataBean, String> {
	
	List<ServiceProviderDataBean> findAllByServicetype(String servicetype);

}
