package com.github.awvalenti.zssn.model;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TradeTest {

	@Test
	public void trades_with_different_values_should_be_rejected() {
		Map<Item, Integer> map1 = new HashMap<>();
		map1.put(Item.AMMUNITION, 1);
		ItemCollection offer1 = new ItemCollection(map1);

		Map<Item, Integer> map2 = new HashMap<>();
		map2.put(Item.MEDICATION, 1);
		ItemCollection offer2 = new ItemCollection(map2);

		assertThat(new Trade(offer1, offer2).isValid(), is(false));
	}

	@Test
	public void trades_with_equal_value_should_be_accepted() {
		Map<Item, Integer> map1 = new HashMap<>();
		map1.put(Item.AMMUNITION, 2);
		ItemCollection offer1 = new ItemCollection(map1);

		Map<Item, Integer> map2 = new HashMap<>();
		map2.put(Item.MEDICATION, 1);
		ItemCollection offer2 = new ItemCollection(map2);

		assertThat(new Trade(offer1, offer2).isValid(), is(true));
	}

}
