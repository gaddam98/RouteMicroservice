/**********************************************************************************
 - File Name        : RouteService
 - Author           : Ramyasree Gaddam	
 - Creation Date    : 11-06-2020
 - Description      : This is service interface to do all kind of operation from dto class.
  ********************************************************************************/
package com.cg.busbooking.route.services;

import java.util.List;

import com.cg.busbooking.route.dto.Route;
import com.cg.busbooking.route.entity.RouteEntity;
import com.cg.busbooking.route.exception.RouteIdNotFoundException;
import com.cg.busbooking.route.exception.RouteNotFoundException;

public interface RouteService {

	public String addRouteDetails(RouteEntity route);

	public List<Route> getAllRouteDetails();

	public Route getRouteById(int routeId) throws RouteIdNotFoundException;

	public String updateSource(int routeId, String source) throws RouteIdNotFoundException;

	public String updateDestination(int routeId, String destination) throws RouteIdNotFoundException;

	public String deleteRouteById(int routeId) throws RouteIdNotFoundException;
	
	public Route getRouteBySourceDestination(String source, String destination) throws RouteNotFoundException;
}
