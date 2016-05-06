package com.github.awvalenti.zssn.service;

import static com.github.awvalenti.zssn.model.Item.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.model.ItemCollection;
import com.github.awvalenti.zssn.model.Survivor;

public class TradeServiceTest {

	private TradeService tradeService;

	private Survivor human1;
	private Survivor human2;
	private Survivor zombie1;
	private Survivor zombie2;

	@Before
	public void setUp() {
		tradeService = new TradeService();

		human1 = new Survivor();
		human1.setZombie(false);
		human2 = new Survivor();
		human2.setZombie(false);

		zombie1 = new Survivor();
		zombie1.setZombie(true);
		zombie2 = new Survivor();
		zombie2.setZombie(true);
	}

	@Test
	public void trade_involving_zombie_should_be_rejected() {
		ItemCollection offer1 = items(FOOD, 1);
		ItemCollection offer2 = items(FOOD, 1);
		assertThat(tradeService.validate(human1, offer1, zombie2, offer2), is(false));
		assertThat(tradeService.validate(zombie1, offer1, human2, offer2), is(false));
		assertThat(tradeService.validate(zombie1, offer1, zombie2, offer2), is(false));
	}

	@Test
	public void trade_involving_humans_with_different_amount_of_points_should_be_rejected() {
		ItemCollection offer1 = items(WATER, 1, MEDICATION, 1);
		ItemCollection offer2 = items(FOOD, 20);
		assertThat(tradeService.validate(human1, offer1, human2, offer2), is(false));
	}

	@Test
	public void trade_involving_humans_with_same_amount_of_points_should_be_accepted() {
		ItemCollection offer1 = items(WATER, 1, MEDICATION, 1);
		ItemCollection offer2 = items(FOOD, 2);
		assertThat(tradeService.validate(human1, offer1, human2, offer2), is(true));
	}

	@Test
	public void accepted_trade_should_transfer_items_between_traders() {
		human1.setInventory(items(WATER, 11, MEDICATION, 11, FOOD, 1, AMMUNITION, 2));
		ItemCollection offer1 = items(WATER, 1, MEDICATION, 1);

		human2.setInventory(items(FOOD, 2));
		ItemCollection offer2 = items(FOOD, 2);

		tradeService.trade(human1, offer1, human2, offer2);
		assertThat(human1.getInventory(), is(items(WATER, 10, MEDICATION, 10, FOOD, 3, AMMUNITION, 2)));
		assertThat(human2.getInventory(), is(items(WATER, 1, MEDICATION, 1)));
	}

	private static ItemCollection items(Object... args) {
		return ItemCollection.with(args);
	}

}
