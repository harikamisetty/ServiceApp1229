package com.hari.serviceapp.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPersonalInfoRepository extends JpaRepository<UserPersonalInfo, String> {

}
