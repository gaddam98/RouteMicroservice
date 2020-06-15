/**********************************************************************************
 - File Name        : Route
 - Author           : Ramyasree Gaddam	
 - Creation Date    : 11-06-2020
 - Description      : This is a dto class.
  ********************************************************************************/
package com.cg.busbooking.route.dto;

import org.springframework.stereotype.Component;

@Component
public class Route {
	
	private int routeId;

	private String source;

	private String destination;
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + "]";
	}
	public Route() {
		super();
	}
	
	public Route(int routeId, String source, String destination) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
	}
	
	
}
