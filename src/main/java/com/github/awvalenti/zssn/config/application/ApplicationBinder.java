package com.github.awvalenti.zssn.config.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.github.awvalenti.zssn.domain.service.TradeService;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class ApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(TradeService.class).to(TradeService.class);
		bind(SurvivorRepository.class).to(SurvivorRepository.class);
		bindFactory(ApplicationEntityManagerFactoryFactory.class).to(EntityManagerFactory.class);
		bindFactory(ApplicationEntityManagerFactory.class).to(EntityManager.class);
	}

}
