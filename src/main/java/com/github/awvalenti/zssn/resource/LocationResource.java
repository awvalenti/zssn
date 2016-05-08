package com.github.awvalenti.zssn.resource;

import javax.inject.Inject;

import com.github.awvalenti.zssn.domain.entity.Location;
import com.github.awvalenti.zssn.repository.LocationRepository;

public class LocationResource {

	private final LocationRepository repo;

	@Inject
	public LocationResource(LocationRepository repo) {
		this.repo = repo;
	}

	public void put(long survivorId, Location newLocation) {
		repo.update(survivorId, newLocation);
	}

	public Location getOne(long survivorId) {
		return repo.getOne(survivorId);
	}

}
