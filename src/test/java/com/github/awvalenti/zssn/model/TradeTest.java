package com.github.awvalenti.zssn.model;

import static com.github.awvalenti.zssn.model.Item.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TradeTest {

	private Survivor human1;
	private Survivor human2;
	private Survivor zombie1;
	private Survivor zombie2;

	@Before
	public void setUp() {
		human1 = mock(Survivor.class);
		human2 = mock(Survivor.class);
		when(human1.isZombie()).thenReturn(false);
		when(human2.isZombie()).thenReturn(false);

		zombie1 = mock(Survivor.class);
		zombie2 = mock(Survivor.class);
		when(zombie1.isZombie()).thenReturn(true);
		when(zombie2.isZombie()).thenReturn(true);
	}

	@Test
	public void trade_involving_zombie_should_be_rejected() {
		ItemCollection offer1 = items(FOOD, 1);
		ItemCollection offer2 = items(FOOD, 1);
		assertThat(new Trade(human1, offer1, zombie2, offer2).isValid(), is(false));
		assertThat(new Trade(zombie1, offer1, human2, offer2).isValid(), is(false));
		assertThat(new Trade(zombie1, offer1, zombie2, offer2).isValid(), is(false));
	}

	@Test
	public void trade_involving_humans_with_different_amount_of_points_should_be_rejected() {
		ItemCollection offer1 = items(WATER, 1, MEDICATION, 1);
		ItemCollection offer2 = items(FOOD, 20);
		assertThat(new Trade(human1, offer1, human2, offer2).isValid(), is(false));
	}

	@Test
	public void trade_involving_humans_with_same_amount_of_points_should_be_accepted() {
		ItemCollection offer1 = items(WATER, 1, MEDICATION, 1);
		ItemCollection offer2 = items(FOOD, 2);
		assertThat(new Trade(human1, offer1, human2, offer2).isValid(), is(true));
	}

	@Test
	public void accepted_trade_should_transfer_items_between_traders() {
		ItemCollection offer1 = items(WATER, 1, MEDICATION, 1);
		ItemCollection offer2 = items(FOOD, 2);
		assertThat(new Trade(human1, offer1, human2, offer2).isValid(), is(true));
	}

	private static ItemCollection items(Object... args) {
		return ItemCollection.with(args);
	}

}
