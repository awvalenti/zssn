package com.github.awvalenti.zssn.domain.service;

import javax.inject.Inject;

import com.github.awvalenti.zssn.domain.entity.ItemCollection;
import com.github.awvalenti.zssn.domain.entity.Survivor;
import com.github.awvalenti.zssn.domain.service.exception.ZombieCannotCheckRepository;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class InventoryService {

	private final SurvivorRepository repo;

	@Inject
	public InventoryService(SurvivorRepository repo) {
		this.repo = repo;
	}

	public ItemCollection checkInventory(long survivorId) throws ZombieCannotCheckRepository {
		Survivor survivor = repo.getOne(survivorId);

		if (survivor.isZombie()) throw new ZombieCannotCheckRepository();

		return survivor.getInventory();
	}

}
