package com.github.awvalenti.zssn.resource;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.model.Survivor;
import com.github.awvalenti.zssn.repository.ContaminationFlagRepository;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class ContaminationFlagResourceTest {

	private ContaminationFlagResource flagResource;
	private List<Survivor> survivors;
	private SurvivorResource survivorResource;

	@Before
	public void setUp() throws Exception {
		survivors = new ArrayList<>(asList(new Survivor(1L), new Survivor(2L), new Survivor(3L),
				new Survivor(4L), new Survivor(5L)));

		SurvivorRepository survivorRepo = new SurvivorRepository(survivors);
		survivorResource = new SurvivorResource(survivorRepo);

		flagResource = new ContaminationFlagResource(new ContaminationFlagRepository(survivorRepo));
	}

	@Test
	public void two_or_less_flags_should_keep_survivor_human() {
		flagResource.post(2L, 5L);
		flagResource.post(3L, 5L);
		assertIsHuman();
	}

	@Test
	public void three_or_more_flags_from_different_reporters_should_turn_survivor_into_zombie() {
		flagResource.post(1L, 5L);
		flagResource.post(2L, 5L);
		flagResource.post(3L, 5L);
		assertIsZombie();

		flagResource.post(4L, 5L);
		assertIsZombie();
	}

	@Test
	public void redundant_flags_should_be_ignored() {
		flagResource.post(2L, 5L);
		flagResource.post(2L, 5L);
		flagResource.post(3L, 5L);
		flagResource.post(3L, 5L);
		assertIsHuman();
	}

	@Test
	public void self_flagging_should_be_ignored() {
		flagResource.post(3L, 5L);
		flagResource.post(4L, 5L);
		flagResource.post(5L, 5L);
		assertIsHuman();
	}

	private void assertIsHuman() {
		assertThat(survivorResource.getOne(5L).isZombie(), is(false));
	}

	private void assertIsZombie() {
		assertThat(survivorResource.getOne(5L).isZombie(), is(true));
	}

}
