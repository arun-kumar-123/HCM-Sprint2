package com.capgemini.hcm.util;

public class ResponseModel {

	private String message;
	private Integer status;
	private Object object;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	@Override
	public String toString() {
		return "ResponseBody [message=" + message + ", status=" + status + ", object=" + object + "]";
	}
	public void setObject1(Object deletecenter) {
		// TODO Auto-generated method stub
		
	}

}
