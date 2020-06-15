/**********************************************************************************
 - File Name        : RouteServiceImpl
 - Author           : Ramyasree Gaddam	
 - Creation Date    : 11-06-2020
 - Description      : This is service class to do all kind of operation from dto class. 
  ********************************************************************************/
package com.cg.busbooking.route.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.busbooking.route.dao.RouteRepository;
import com.cg.busbooking.route.dto.Route;
import com.cg.busbooking.route.entity.RouteEntity;
import com.cg.busbooking.route.exception.RouteIdNotFoundException;
import com.cg.busbooking.route.exception.RouteNotFoundException;

@Service
public class RouteServicesImpl implements RouteService {

	@Autowired
	private RouteRepository repository;

	@Override
	public String addRouteDetails(RouteEntity route) {
		//RouteEntity entity= new RouteEntity();
		repository.saveAndFlush(route);
		return "New Route added succesfully";
	}

	@Override
	public List<Route> getAllRouteDetails() {
		List<RouteEntity> entityList = repository.findAll();
		List<Route> routeList = new ArrayList<>();
		for (RouteEntity entity : entityList) {
			Route route = new Route();
			route.setRouteId(entity.getRouteId());
			route.setSource(entity.getSource());
			route.setDestination(entity.getDestination());
			routeList.add(route);
		}
		return routeList;
	}

	@Override
	public Route getRouteById(int routeId) throws RouteIdNotFoundException {
		Optional<RouteEntity> optional = repository.findById(routeId);
		if(optional.isPresent()) {
			RouteEntity entity= optional.get();
			Route route= new Route();
			route.setRouteId(entity.getRouteId());
			route.setSource(entity.getSource());
			route.setDestination(entity.getDestination());
			return route;
		}
		else {
			throw new RouteIdNotFoundException("RouteId not found");
		}
	}

	@Override
	public String updateSource(int routeId, String source) throws RouteIdNotFoundException {
		Optional<RouteEntity> optional = repository.findById(routeId);
		RouteEntity entity = optional.get();
		if(optional.isPresent()) {
			entity=optional.get();
			entity.setSource(source);
			repository.saveAndFlush(entity);
			return routeId+" Source Updated Successfully";
		}
		else {
			throw new RouteIdNotFoundException("RouteId not found");
		}

	}

	@Override
	public String updateDestination(int routeId, String destination) throws RouteIdNotFoundException {
		Optional<RouteEntity> optional = repository.findById(routeId);
		RouteEntity entity = optional.get();
		if(optional.isPresent()) {
			entity= optional.get();
			entity.setDestination(destination);
			repository.save(entity);
			return routeId+" Destination Updated Successfully";
		}
		else {
			throw new RouteIdNotFoundException("RouteId not found");
		}
	}

	@Override
	public String deleteRouteById(int routeId) throws RouteIdNotFoundException {
		Optional<RouteEntity> optional= repository.findById(routeId);
		if(optional.isPresent()) {
			repository.deleteById(routeId);
			return routeId+" Details Deleted Sucessfully";
		}else {
			throw new RouteIdNotFoundException("RouteId not found");
		}
	}

	@Override
	public Route getRouteBySourceDestination(String source, String destination) throws RouteNotFoundException{
		Optional<RouteEntity> optional = repository.getRouteDetails(source, destination);
		if(optional.isPresent()) {
			RouteEntity entity= optional.get();
			Route route = new Route();
			route.setRouteId(entity.getRouteId());
			route.setSource(entity.getSource());
			route.setDestination(entity.getDestination());
			return route;
		}
		else {
			throw new RouteNotFoundException("Route not found");
		}
	}
}