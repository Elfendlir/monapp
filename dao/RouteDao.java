package com.monapp.dao;

import java.util.List;

import com.monapp.entity.Route;

public interface RouteDao extends GenericDao<Route, Integer> {

	Route getRouteInitiale(Integer id);
	List<Route> getRoutesByScenarioId(Integer id);
}