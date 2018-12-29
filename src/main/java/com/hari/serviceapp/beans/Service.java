package com.hari.serviceapp.beans;

import com.hari.serviceapp.serviceProvider.bean.TimeLine;

public class Service {
	
	private String serviceId;
	private String serviceName;
	private TimeLine timeLine;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public TimeLine getTimeLine() {
		return timeLine;
	}
	public void setTimeLine(TimeLine timeLine) {
		this.timeLine = timeLine;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}
