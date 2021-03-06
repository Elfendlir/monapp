package com.monapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.monapp.entity.Inventaire;

@Transactional
@Repository
public class InventaireDaoImpl implements InventaireDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Inventaire findByPrimaryKey(Integer id) {
		return em.find(Inventaire.class, id);
	}

	@Override
	public List<Inventaire> findAll() {
		String querystring = "SELECT i FROM Inventaire i ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<Inventaire> list = query.getResultList() ;
		return list;
	}

	@Override
	public Inventaire save(Inventaire entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Inventaire entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Inventaire update(Inventaire entity) {
		return em.merge(entity);
	}

}
