package com.monapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.monapp.entity.Partie;
import com.monapp.entity.Personnage;

@Transactional
@Repository
public class PersonnageDaoImpl implements PersonnageDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Personnage> findAll() {
		String querystring = "SELECT i FROM Personnage i ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<Personnage> list = query.getResultList() ;
		return list;
	}
	@Override
	public List<Personnage> findFreePersonnages() {
		String querystring = "SELECT i FROM Personnage i WHERE NOT EXISTS (SELECT p.perso FROM Partie p WHERE i = p.perso)" ;
		Query query = em.createQuery( querystring ) ;
		List<Personnage> list = query.getResultList() ;
		return list;
	}
	@Override
	public Personnage save(Personnage entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Personnage entity) {
		entity = em.merge(entity);
		Partie partie = entity.getPartie();
		if(partie != null) {
			partie.setPerso(null);
			em.remove(partie);
		}
		em.remove(entity);
	}

	public Personnage findByPrimaryKey(Integer id) {
		return em.find(Personnage.class, id);
	}

	@Override
	public Personnage update(Personnage entity) {
		return em.merge(entity);
	}
}