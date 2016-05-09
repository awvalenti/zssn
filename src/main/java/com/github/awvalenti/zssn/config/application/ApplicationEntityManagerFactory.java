package com.github.awvalenti.zssn.config.application;

import java.io.Closeable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.glassfish.hk2.api.Factory;
import org.glassfish.jersey.server.CloseableService;

public class ApplicationEntityManagerFactory implements Factory<EntityManager> {

	private final CloseableService closeableService;
	private final EntityManagerFactory emf;

	@Inject
	public ApplicationEntityManagerFactory(CloseableService closeableService,
			EntityManagerFactory emf) {
		this.closeableService = closeableService;
		this.emf = emf;
	}

	@Override
	public void dispose(EntityManager em) {
		// Not called at all
	}

	@Override
	@SuppressWarnings("resource")
	public EntityManager provide() {
		final EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		closeableService.add(new Closeable() {
			@Override
			public final void close() {
				em.getTransaction().commit();
				em.close();
			}
		});

		return em;
	}

	// TODO Rollback transaction if an error occurs

}
