package com.hari.serviceapp.signup.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "service_provider")
@EntityListeners(AuditingEntityListener.class)
public class ServiceProviderDataBean {
	
	@Id
	@Column(name="serviceid")
	private String serviceid;
	@Column(name="userid")
	private String userid;
	@Column(name="servicetype")
	private String servicetype;
	@Column(name="servicedescription")
	private String servicedescription;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	
	public String getServiceid() {
		return serviceid;
	}
	public void setServiceid(String serviceid) {
		this.serviceid = serviceid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getServicedescription() {
		return servicedescription;
	}
	public void setServicedescription(String servicedescription) {
		this.servicedescription = servicedescription;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
