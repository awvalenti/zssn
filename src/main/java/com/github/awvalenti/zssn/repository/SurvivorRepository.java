package com.github.awvalenti.zssn.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.awvalenti.zssn.domain.entity.Survivor;

public class SurvivorRepository {

	private final EntityManager em;

	@Inject
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
