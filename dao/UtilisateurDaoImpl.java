package com.monapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.monapp.entity.Utilisateur;

@Transactional
@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Utilisateur> findAll() {
		String querystring = "SELECT i FROM Utilisateur i ORDER BY id" ;
		Query query = em.createQuery( querystring ) ;
		List<Utilisateur> list = query.getResultList() ;
		return list;
	}

	@Override
	public Utilisateur save(Utilisateur entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void delete(Utilisateur entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	public Utilisateur findByPrimaryKey(Integer id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public Utilisateur update(Utilisateur entity) {
		return em.merge(entity);
	}
	
	public Utilisateur login(String email, String mdp) {
		String querystring = "SELECT u FROM Utilisateur u WHERE u.email=? AND u.mdp=?" ;
		Query query = em.createQuery( querystring ) ;
		query.setParameter(0, email);
		query.setParameter(1, mdp);
		List<Utilisateur> list = query.getResultList() ;
		return list.get(0);
	}
}