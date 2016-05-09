package com.github.awvalenti.zssn.repository;

import javax.inject.Inject;

import com.github.awvalenti.zssn.domain.entity.Location;

public class LocationRepository {

	private final SurvivorRepository survivorRepo;

	@Inject
	public LocationRepository(SurvivorRepository survivorRepo) {
		this.survivorRepo = survivorRepo;
	}

	public Location getOne(long survivorId) {
		return survivorRepo.getOne(survivorId).getLocation();
	}

	public void update(long survivorId, Location newLocation) {
		survivorRepo.getOne(survivorId).setLocation(newLocation);
	}

}
