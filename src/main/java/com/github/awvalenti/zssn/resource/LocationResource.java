package com.github.awvalenti.zssn.resource;

import com.github.awvalenti.zssn.model.Location;
import com.github.awvalenti.zssn.repository.LocationRepository;

public class LocationResource {

	private final LocationRepository repo;

	public LocationResource(LocationRepository repo) {
		this.repo = repo;
	}

	public void put(long survivorId, Location newLocation) {
		Location oldLocation = repo.getById(survivorId);
		oldLocation.setLatitude(newLocation.getLatitude());
		oldLocation.setLongitude(newLocation.getLongitude());
	}

	public Location getOne(Long survivorId) {
		return repo.getById(survivorId);
	}

}
