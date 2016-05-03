package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.model.Location;
import com.github.awvalenti.zssn.model.Survivor;
import com.github.awvalenti.zssn.repository.LocationRepository;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class LocationResourceTest {

	private LocationResource locationResource;

	@Before
	public void setUp() throws Exception {
		SurvivorRepository survivorRepo = new SurvivorRepository();
		Survivor survivor = new Survivor();
		survivor.setLocation(new Location(1, 1));
		new SurvivorResource(survivorRepo).post(survivor);
		locationResource = new LocationResource(new LocationRepository(survivorRepo));
	}

	@Test
	public void should_update_location() {
		locationResource.put(1L, new Location(2, 2));
		assertThat(locationResource.getOne(1L), is(new Location(2, 2)));
	}

}
