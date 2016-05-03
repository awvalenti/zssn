package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.model.Survivor;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class SurvivorResourceTest {

	private SurvivorResource survivorResource;

	@Before
	public void setUp() throws Exception {
		survivorResource = new SurvivorResource(new SurvivorRepository());
	}

	@Test
	public void should_add_survivor() {
		Survivor john = new Survivor();
		john.setName("John Doe");

		survivorResource.post(john);
		assertThat(survivorResource.getOne(1L).getName(), is("John Doe"));
	}

}
