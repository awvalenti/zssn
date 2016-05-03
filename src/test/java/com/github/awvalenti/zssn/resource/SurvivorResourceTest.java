package com.github.awvalenti.zssn.resource;

import static java.util.Arrays.*;
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

public class SurvivorResourceTest {

	private SurvivorResource survivorResource;

	@Before
	public void setUp() throws Exception {
		survivorResource = new SurvivorResource(new SurvivorRepository(), new LocationRepository());
	}

	@Test
	public void should_add_survivor() {
		survivorResource.post(new Survivor("John Doe", 21, Gender.MALE, new Location(29.99, 10.99),
				new HashSet<>(asList(Item.AMMUNITION))));

		Survivor john = survivorResource.getOne(1L);

		assertThat(john.getName(), is("John Doe"));
		assertThat(john.getAge(), is(21));
		assertThat(john.getGender(), is(Gender.MALE));
		assertThat(john.getLocation(), is(new Location(29.99, 10.99)));
		assertThat(john.getInventory(), contains(Item.AMMUNITION));
	}

}
