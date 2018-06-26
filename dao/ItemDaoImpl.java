package com.monapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.monapp.entity.Item;

@Transactional
@Repository
public class ItemDaoImpl implements ItemDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Item findByPrimaryKey(Integer id) {
		return em.find(Item.class, id);
	}

	@Override
	public List<Item> findAll() {
		String querystring = "SELECT i FROM Item i ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<Item> list = query.getResultList() ;
		return list;
	}

	@Override
	public Item save(Item entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Item entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public Item update(Item entity) {
		return em.merge(entity);
	}

}
