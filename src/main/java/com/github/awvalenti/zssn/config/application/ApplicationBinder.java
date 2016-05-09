package com.github.awvalenti.zssn.config.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.github.awvalenti.zssn.domain.service.ContaminationFlagService;
import com.github.awvalenti.zssn.domain.service.InventoryService;
import com.github.awvalenti.zssn.domain.service.TradeService;
import com.github.awvalenti.zssn.repository.ContaminationFlagDatabaseRepository;
import com.github.awvalenti.zssn.repository.ContaminationFlagRepository;
import com.github.awvalenti.zssn.repository.LocationRepository;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class ApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(ContaminationFlagService.class).to(ContaminationFlagService.class);
		bind(TradeService.class).to(TradeService.class);
		bind(InventoryService.class).to(InventoryService.class);

		bind(SurvivorRepository.class).to(SurvivorRepository.class);
		bind(LocationRepository.class).to(LocationRepository.class);
		bind(ContaminationFlagRepository.class).to(ContaminationFlagDatabaseRepository.class);

		bindFactory(ApplicationEntityManagerFactoryFactory.class).to(EntityManagerFactory.class);
		bindFactory(ApplicationEntityManagerFactory.class).to(EntityManager.class);
	}

}
