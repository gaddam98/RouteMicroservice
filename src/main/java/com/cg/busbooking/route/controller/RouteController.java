/****************************************************************************************************************************
 - File Name        : RouteController
 - Author           : Ramyasree Gaddam	
 - Creation Date    : 11-06-2020
 - Description      : This is an end point controller to consume Route Service.
  ****************************************************************************************************************************/ 

package com.cg.busbooking.route.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.busbooking.route.dto.Route;
import com.cg.busbooking.route.entity.RouteEntity;
import com.cg.busbooking.route.exception.RouteIdNotFoundException;
import com.cg.busbooking.route.exception.RouteNotFoundException;
import com.cg.busbooking.route.services.RouteServicesImpl;

@RestController
@RequestMapping(value = "/route")
@Validated
public class RouteController {

	@Autowired
	private RouteServicesImpl service;

	//ADD ROUTE
	/****************************************************************************************************************************
	 - Method Name      : addRoute
	 - Return type      : ResponseEntity<String>
	 - Author           : Ramyasree Gaddam
	 - Creation Date    : 11-06-2020
	 - Description      : Add new Route
	 -End Point URL		: http://localhost:9092/route/addroute
	  ****************************************************************************************************************************/ 
	@PostMapping(value = "/addroute")
	public ResponseEntity<String>  addRouteDetails(@Valid @RequestBody RouteEntity route) {
		return new ResponseEntity<>(service.addRouteDetails(route),HttpStatus.ACCEPTED);
	}

	//DISPLAY ALL ROUTE DETAILS
	/****************************************************************************************************************************
	 - Method Name      : getAllRouteDetails
	 - Return type      : List<Route>
	 - Author           : Ramyasree Gaddam
	 - Creation Date    : 11-06-2020
	 - Description      : Get all Route details
	 -End Point URL		: http://localhost:9092/route/fetchroutedetails
	  ****************************************************************************************************************************/ 
	@GetMapping("/fetchroutedetails")
	public List<Route> getAllRouteDetails() {
		return service.getAllRouteDetails();
	}

	//DISPLAY ROUTE DETAILS BY ID
	/****************************************************************************************************************************
	 - Method Name      : getRouteById
	 - Return type      : ResponseEntity<String>
	 - Author           : Ramyasree Gaddam
	 - Creation Date    : 11-06-2020
	 - Description      : Get Route details bye Route Id
	 -End Point URL		: http://localhost:9092/route/fetchroutebyId/
	  ****************************************************************************************************************************/ 
	@GetMapping("/fetchroutebyId/{routeId}")
	public ResponseEntity<Route> getRouteById(@PathVariable("routeId") int routeId) throws RouteIdNotFoundException {
		Route route= service.getRouteById(routeId);
		return new ResponseEntity<>(route,HttpStatus.OK);
	}

	//UPDATE SOURCE USING ID
	/****************************************************************************************************************************
	 - Method Name      : updateSource
	 - Return type      : ResponseEntity<String>
	 - Author           : Ramyasree Gaddam
	 - Creation Date    : 11-06-2020
	 - Description      : To Upadte Source
	 -End Point URL		: http://localhost:9092/route/updatesource/source/
	  ****************************************************************************************************************************/ 
	@PutMapping("/updatesource/source/{routeId}")
	public ResponseEntity<String> updateSource(@PathVariable("routeId") int routeId, @RequestBody Route route)
			throws RouteIdNotFoundException {
		String msg = service.updateSource(routeId, route.getSource());
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	//UPDATE DESTINATION USING ID
	/****************************************************************************************************************************
	 - Method Name      : updateDestination
	 - Return type      : ResponseEntity<String>
	 - Author           : Ramyasree Gaddam
	 - Creation Date    : 11-06-2020
	 - Description      : To Upadte Destination
	 -End Point URL		: http://localhost:9092/route/updatedestination/destination
	  ****************************************************************************************************************************/ 
	@PutMapping("/updatedestination/destination/{routeId}")
	public ResponseEntity<String> updateDestination(@Valid @PathVariable("routeId") int routeId,
			@RequestBody Route route) throws RouteIdNotFoundException {
		String msg = service.updateDestination(routeId, route.getDestination());
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	//DELETE ROUTE DETAILS BY ID
	/****************************************************************************************************************************
	 - Method Name      : deleteRouteById
	 - Return type      : ResponseEntity<String>
	 - Author           : Ramyasree Gaddam
	 - Creation Date    : 11-06-2020
	 - Description      : To Delete Route
	 -End Point URL		: http://localhost:9092/route/delete/
	  ****************************************************************************************************************************/ 
	@DeleteMapping("/delete/{routeId}")
	public ResponseEntity<String> deleteRouteById(@PathVariable("routeId") int routeId) throws RouteIdNotFoundException {
		return ResponseEntity.ok(service.deleteRouteById(routeId));
	}
	
	//DISPLAYING ROUTE DETAILS USING SOURCE AND DESTINATION
	/****************************************************************************************************************************
	 - Method Name      : getRouteBySourceDestination
	 - Return type      : ResponseEntity<Route>
	 - Author           : Ramyasree Gaddam
	 - Creation Date    : 11-06-2020
	 - Description      : Get Route details by Source and Destination
	 -End Point URL		: http://localhost:9092/route/fetchroutedetailsbysourcedestination
	  ****************************************************************************************************************************/ 
	@GetMapping(value = "/fetchroutedetailsbysourcedestination/{source}/{destination}")
	public ResponseEntity<Route> getRouteBySourceDestination(@PathVariable("source") String source, @PathVariable("destination") String destination) throws RouteNotFoundException{
		Route route = service.getRouteBySourceDestination(source, destination);
		return new ResponseEntity<>(route, HttpStatus.OK);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolation(ConstraintViolationException e) {
		return new ResponseEntity<>(": " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
