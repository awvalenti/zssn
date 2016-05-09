package com.github.awvalenti.zssn.domain.service;

import static com.github.awvalenti.zssn.domain.entity.Item.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.domain.entity.ItemCollection;
import com.github.awvalenti.zssn.domain.entity.Survivor;
import com.github.awvalenti.zssn.domain.entity.Trade;
import com.github.awvalenti.zssn.domain.service.exception.InvalidTrade;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class TradeServiceTest {

	private TradeService tradeService;

	private Survivor human1;
	private Survivor human2;
	private Survivor zombie3;
	private Survivor zombie4;

	@Before
	public void setUp() {
		human1 = Survivor.human(1);
		human2 = Survivor.human(2);
		zombie3 = Survivor.zombie(3);
		zombie4 = Survivor.zombie(4);

		SurvivorRepository repo = mock(SurvivorRepository.class);
		when(repo.getOne(1L)).thenReturn(human1);
		when(repo.getOne(2L)).thenReturn(human2);
		when(repo.getOne(3L)).thenReturn(zombie3);
		when(repo.getOne(4L)).thenReturn(zombie4);

		tradeService = new TradeService(repo);
	}

	@Test
	public void trade_involving_zombie_should_be_rejected() {
		ItemCollection offer1 = items(FOOD, 1);
		ItemCollection offer2 = items(FOOD, 1);
		assertThat(tradeService.validate(human1, offer1, zombie4, offer2), is(false));
		assertThat(tradeService.validate(zombie3, offer1, human2, offer2), is(false));
		assertThat(tradeService.validate(zombie3, offer1, zombie4, offer2), is(false));
	}

	@Test
	public void trade_involving_humans_with_different_points_should_be_rejected() {
		ItemCollection offer1 = items(WATER, 1, MEDICATION, 1);
		ItemCollection offer2 = items(FOOD, 20);
		assertThat(tradeService.validate(human1, offer1, human2, offer2), is(false));
	}

	@Test
	public void trade_involving_humans_with_same_points_should_be_accepted() {
		ItemCollection offer1 = items(WATER, 1, MEDICATION, 1);
		ItemCollection offer2 = items(FOOD, 2);
		assertThat(tradeService.validate(human1, offer1, human2, offer2), is(true));
	}

	@Test
	public void accepted_trade_should_transfer_items_between_traders() throws InvalidTrade {
		human1.setInventory(items(WATER, 11, MEDICATION, 11, FOOD, 1, AMMUNITION, 2));
		ItemCollection offer1 = items(WATER, 1, MEDICATION, 1);

		human2.setInventory(items(FOOD, 2));
		ItemCollection offer2 = items(FOOD, 2);

		tradeService.trade(new Trade(1L, 2L, offer1, offer2));
		assertThat(human1.getInventory(), is(items(WATER, 10, MEDICATION, 10, FOOD, 3, AMMUNITION, 2)));
		assertThat(human2.getInventory(), is(items(WATER, 1, MEDICATION, 1)));
	}

	private static ItemCollection items(Object... args) {
		return ItemCollection.with(args);
	}

}
