/**********************************************************************************
 - File Name        : RouteRepository
 - Author           : Ramyasree Gaddam	
 - Creation Date    : 11-06-2020
 - Description      : This is a repository interface.
  ********************************************************************************/
package com.cg.busbooking.route.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.busbooking.route.entity.RouteEntity;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Integer>{
	
	@Query("select r from RouteEntity r where r.source= :source and r.destination= :destination")
	Optional<RouteEntity> getRouteDetails(String source, String destination);
}