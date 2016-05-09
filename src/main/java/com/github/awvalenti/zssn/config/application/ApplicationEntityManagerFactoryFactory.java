package com.github.awvalenti.zssn.config.application;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.glassfish.hk2.api.Factory;

public class ApplicationEntityManagerFactoryFactory implements Factory<EntityManagerFactory> {

	// XXX Should be application scoped instead of static, but couldn't find how
	// TODO Close when server is stopped
	private static final EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("hsqldb");
	}

	@Override
	public void dispose(EntityManagerFactory em) {
		// Not called at all
	}

	@Override
	public EntityManagerFactory provide() {
		return emf;
	}

}
