package com.cg.busbooking.route.exception;

public class RouteNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	final String msg;
	public RouteNotFoundException(String msg) {
		super();
		this.msg= msg;
	}	
	
	@Override
	public String getMessage() {
		return msg;
	}
}