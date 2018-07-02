package com.monapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.monapp.entity.Route;

@Transactional
@Repository
public class RouteDaoImpl implements RouteDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Route> findAll() {
		String querystring = "SELECT i FROM Route i ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<Route> list = query.getResultList() ;
		return list;
	}

	@Override
	public Route save(Route entity) {
		em.persist(entity);
		List<Route> list = entity.getListeRoutesSuivantes();
		for (Route route : list) {
			route.setRouteInitiale(entity);
			em.merge(route);
		}
		return entity;
	}

	@Override
	public void delete(Route entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public Route findByPrimaryKey(Integer id) {
		return em.find(Route.class, id);
	}

	@Override
	public Route update(Route entity) {
		return em.merge(entity);
	}
}