package com.github.awvalenti.zssn.config;

import java.io.Closeable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.glassfish.hk2.api.Factory;
import org.glassfish.jersey.server.CloseableService;

public class ApplicationEntityManagerFactory implements Factory<EntityManager> {

	private final CloseableService closeableService;

	private final EntityManagerFactory emf;

	@Inject
	public ApplicationEntityManagerFactory(CloseableService closeableService) {
		this.closeableService = closeableService;
		this.emf = Persistence.createEntityManagerFactory("hsqldb");
	}

	@Override
	public void dispose(EntityManager em) {
		em.close();
	}

	@Override
	@SuppressWarnings("resource")
	public EntityManager provide() {
		final EntityManager em = emf.createEntityManager();

		closeableService.add(new Closeable() {
			@Override
			public final void close() {
				em.close();
			}
		});

		return em;
	}
}
