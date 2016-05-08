package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class SurvivorResourceTest extends IntegrationTest {

	private SurvivorResource survivorResource;

	@Before
	public void setUp() throws Exception {
		survivorResource = new SurvivorResource(new SurvivorRepository(em));
	}

	@Test
	public void should_add_survivor() {
		survivorResource.post(createJohnDoe());
		assertThat(survivorResource.getOne(1L).getName(), is("John Doe"));
	}

}
