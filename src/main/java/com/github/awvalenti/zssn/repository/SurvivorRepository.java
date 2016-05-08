package com.github.awvalenti.zssn.repository;

import javax.persistence.EntityManager;

import com.github.awvalenti.zssn.model.Survivor;

public class SurvivorRepository {

	private final EntityManager em;

	public SurvivorRepository(EntityManager em) {
		this.em = em;
	}

	public void add(Survivor survivor) {
		em.persist(survivor);
	}

	public Survivor getOne(long id) {
		return em.find(Survivor.class, id);
	}

}
