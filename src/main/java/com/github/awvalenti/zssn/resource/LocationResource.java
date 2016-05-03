package com.github.awvalenti.zssn.resource;

import com.github.awvalenti.zssn.model.Location;
import com.github.awvalenti.zssn.repository.LocationRepository;

public class LocationResource {

	private final LocationRepository repo;

	public LocationResource(LocationRepository repo) {
		this.repo = repo;
	}

	public void put(long survivorId, Location newLocation) {
		Location oldLocation = repo.getOne(survivorId);
		oldLocation.setLatitude(newLocation.getLatitude());
		oldLocation.setLongitude(newLocation.getLongitude());
	}

	public Location getOne(long survivorId) {
		return repo.getOne(survivorId);
	}

}
