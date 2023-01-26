package com.ciq.model;

public class ResponseBean {
	
	int StatusCode;
	Object msg;
	public ResponseBean(int statusCode, Object msg) {
		super();
		StatusCode = statusCode;
		this.msg = msg;
	}
	public ResponseBean() {
		// TODO Auto-generated constructor stub
	}
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ResponseBean [StatusCode=" + StatusCode + ", msg=" + msg + "]";
	}
   
	
   
}
