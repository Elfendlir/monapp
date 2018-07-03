package com.monapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.monapp.entity.Scenario;

@Transactional
@Repository
public class ScenarioDaoImpl implements ScenarioDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Scenario findByPrimaryKey(Integer id) {
		return em.find(Scenario.class, id);
	}

	@Override
	public List<Scenario> findAll() {
		String querystring = "SELECT i FROM Scenario i ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<Scenario> list = query.getResultList() ;
		return list;
	}

	@Override
	public Scenario save(Scenario entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Scenario entity) {
		entity = em.merge(entity);
		em.remove(entity);
	} 

	@Override
	public Scenario update(Scenario entity) {
		return em.merge(entity);
	}

}
