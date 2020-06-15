/**********************************************************************************
 - File Name        : RouteEntity
 - Author           : Ramyasree Gaddam	
 - Creation Date    : 11-06-2020
 - Description      : This is a entity class.
  ********************************************************************************/
package com.cg.busbooking.route.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "route_db")
public class RouteEntity {
	
	@Id
	@Column(name = "route_id")
	@Min(1000)
	@Max(9000)
	@NotNull(message = "Route Id should no be null")
	private int routeId;
	
	@Column(name = "source")
	@NotNull(message = "Source should no be null")
	@NotBlank(message = "Source should no be blank")
	@Size(min=3, max=30, message="Source must be equal or greater than 3 character and less than 30")
	@Pattern(regexp ="^[A-Za-z]*", message = "Source can only be in alphabets.")
	private String source;
	
	@Column(name = "destination")
	@NotNull(message = "Destination should no be null")
	@NotBlank(message = "Destination should no be blank")
	@Size(min=3, max=30, message="Destination must be equal or greater than 3 character and less than 30")
	@Pattern(regexp ="^[A-Za-z]*", message = "Destination can only be in alphabets.")
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

	public RouteEntity(int routeId, String source, String destination) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
	}

	public RouteEntity() {
		super();
	}

	@Override
	public String toString() {
		return "RouteEntity [routeId=" + routeId + ", source=" + source + ", destination=" + destination + "]";
	}
}
