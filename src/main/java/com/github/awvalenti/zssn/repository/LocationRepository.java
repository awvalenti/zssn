package com.github.awvalenti.zssn.repository;

import java.util.ArrayList;
import java.util.List;

import com.github.awvalenti.zssn.model.Location;

public class LocationRepository {

	private final List<Location> data;

	public LocationRepository() {
		this.data = new ArrayList<>();
	}

	public Location getOne(long survivorId) {
		return data.get((int) survivorId - 1);
	}

	public void add(Location location) {
		data.add(location);
	}

}
