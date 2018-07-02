package com.monapp.dao;

import com.monapp.entity.Utilisateur;

public interface UtilisateurDao extends GenericDao<Utilisateur, Integer> {
	Utilisateur login(String mail, String mdp);
}