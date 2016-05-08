package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.domain.entity.Location;
import com.github.awvalenti.zssn.repository.LocationRepository;
import com.github.awvalenti.zssn.repository.SurvivorRepository;
import com.github.awvalenti.zssn.testsupport.testsuperclass.IntegrationTest;

public class LocationResourceTest extends IntegrationTest {

	private LocationResource locationResource;

	@Before
	public void setUp() throws Exception {
		SurvivorRepository survivorRepo = new SurvivorRepository(em);
		new SurvivorResource(survivorRepo).post(createJohnDoe());
		locationResource = new LocationResource(new LocationRepository(survivorRepo));
	}

	@Test
	public void should_update_location() {
		locationResource.put(1L, new Location(2.0, 2.0));
		assertThat(locationResource.getOne(1L), is(new Location(2.0, 2.0)));
	}

}
