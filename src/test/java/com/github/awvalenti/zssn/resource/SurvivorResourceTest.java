package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.model.Gender;
import com.github.awvalenti.zssn.model.Location;
import com.github.awvalenti.zssn.model.Survivor;
import com.github.awvalenti.zssn.repository.LocationRepository;
import com.github.awvalenti.zssn.repository.SurvivorRepository;
import com.github.awvalenti.zssn.resource.SurvivorResource;

public class SurvivorResourceTest {

	private SurvivorResource survivorResource;

	@Before
	public void setUp() throws Exception {
		survivorResource = new SurvivorResource(new SurvivorRepository(), new LocationRepository());
	}

	@Test
	public void should_add_survivor() {
		Survivor johnDoe = new Survivor("John Doe", 21, Gender.MALE, new Location(29.99, 10.99));
		survivorResource.post(johnDoe);
		assertThat(survivorResource.getAll(), contains(johnDoe));
	}

}
