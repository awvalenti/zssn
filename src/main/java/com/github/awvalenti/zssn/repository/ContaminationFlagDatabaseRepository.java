package com.github.awvalenti.zssn.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.github.awvalenti.zssn.model.ContaminationFlag;

public class ContaminationFlagDatabaseRepository implements ContaminationFlagRepository {

	private final EntityManager em;

	public ContaminationFlagDatabaseRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void add(ContaminationFlag contaminationFlag) {
		em.persist(contaminationFlag);
	}

	@Override
	public List<ContaminationFlag> getAll() {
		return em.createQuery("FROM " + ContaminationFlag.class.getSimpleName(),
				ContaminationFlag.class).getResultList();
	}

}