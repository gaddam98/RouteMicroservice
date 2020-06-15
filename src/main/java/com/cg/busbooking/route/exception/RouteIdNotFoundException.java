package com.cg.busbooking.route.exception;

public class RouteIdNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	final String msg;
	public RouteIdNotFoundException(String msg) {
		super();
		this.msg= msg;
	}	
	
	@Override
	public String getMessage() {
		return msg;
	}
}
