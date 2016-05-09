package com.github.awvalenti.zssn.domain.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.domain.entity.Survivor;
import com.github.awvalenti.zssn.domain.service.ContaminationFlagService;
import com.github.awvalenti.zssn.repository.SurvivorRepository;
import com.github.awvalenti.zssn.testsupport.repository.ContaminationFlagInMemoryRepository;

public class ContaminationFlagServiceTest {

	private SurvivorRepository survivorRepo;
	private ContaminationFlagService flagService;

	@Before
	public void setUp() throws Exception {
		survivorRepo = mock(SurvivorRepository.class);
		when(survivorRepo.getOne(1L)).thenReturn(Survivor.human(1L));
		when(survivorRepo.getOne(2L)).thenReturn(Survivor.human(2L));
		when(survivorRepo.getOne(3L)).thenReturn(Survivor.human(3L));
		when(survivorRepo.getOne(4L)).thenReturn(Survivor.human(4L));
		when(survivorRepo.getOne(5L)).thenReturn(Survivor.human(5L));

		flagService = new ContaminationFlagService(new ContaminationFlagInMemoryRepository(), survivorRepo);
	}

	@Test
	public void two_or_less_flags_should_keep_survivor_human() {
		flagService.add(2L, 5L);
		flagService.add(3L, 5L);
		assertIsHuman();
	}

	@Test
	public void three_or_more_flags_from_different_reporters_should_turn_survivor_into_zombie() {
		flagService.add(1L, 5L);
		flagService.add(2L, 5L);
		flagService.add(3L, 5L);
		assertIsZombie();

		flagService.add(4L, 5L);
		assertIsZombie();
	}

	@Test
	public void redundant_flags_should_be_ignored() {
		flagService.add(2L, 5L);
		flagService.add(2L, 5L);
		flagService.add(3L, 5L);
		flagService.add(3L, 5L);
		assertIsHuman();
	}

	@Test
	public void self_flagging_should_be_ignored() {
		flagService.add(3L, 5L);
		flagService.add(4L, 5L);
		flagService.add(5L, 5L);
		assertIsHuman();
	}

	private void assertIsHuman() {
		assertThat(survivorRepo.getOne(5L).isZombie(), is(false));
	}

	private void assertIsZombie() {
		assertThat(survivorRepo.getOne(5L).isZombie(), is(true));
	}

}
