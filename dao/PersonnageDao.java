package com.monapp.dao;

import java.util.List;

import com.monapp.entity.Personnage;

public interface PersonnageDao extends GenericDao<Personnage, Integer> {
	List<Personnage> findFreePersonnages();
}