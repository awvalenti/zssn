package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.model.Gender;
import com.github.awvalenti.zssn.model.Item;
import com.github.awvalenti.zssn.model.Location;
import com.github.awvalenti.zssn.model.Survivor;
import com.github.awvalenti.zssn.repository.LocationRepository;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class LocationResourceTest {

	private LocationResource locationResource;
	private Survivor johnDoe;

	@Before
	public void setUp() throws Exception {
		LocationRepository locationRepo = new LocationRepository();
		locationResource = new LocationResource(locationRepo);
		johnDoe = new Survivor("John Doe", 21, Gender.MALE, new Location(1, 1), new HashSet<Item>());
		new SurvivorResource(new SurvivorRepository(), locationRepo).post(johnDoe);
	}

	@Test
	public void should_update_location() {
		locationResource.put(johnDoe.getId(), new Location(2, 2));
		assertThat(locationResource.getOne(johnDoe.getId()), is(new Location(2, 2)));
	}

}
