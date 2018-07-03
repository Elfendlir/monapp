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
		String querystring = "SELECT i FROM Route i WHERE i.scenario.id =:id" ;
		Query query = em.createQuery( querystring );
		query.setParameter("id", entity.getScenario().getId());
		List<Route> list2 = query.getResultList();
		System.out.println("TOOOOOOO MANNNNNNNNNNN");
		if(list2.isEmpty())
		{
			entity.setDebut(true);
			System.out.println("QQQQQQQQQQQQQQQQQQ");
		}
		em.merge(entity);
		List<Route> list = entity.getListeRoutesSuivantes();
		if(list != null)
		{
			for (Route route : list) {
				route.setRouteInitiale(entity);
				em.merge(route);
			}
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

	@Override
	public Route getRouteInitiale(Integer id) {
		String querystring = "SELECT i FROM Route i WHERE scenario.id = ? AND premiereRoute = TRUE" ;
		Query query = em.createQuery( querystring );
		query.setParameter(0, id);
		List<Route> list = query.getResultList();
		return list.get(0);
	}

	@Override
	public List<Route> getRoutesByScenarioId(Integer id) {
		String querystring = "SELECT DISTINCT i FROM Route i WHERE i.scenario.id =:id ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		query.setParameter("id", id);
		List<Route> list = query.getResultList() ;
		return list;
	}
}