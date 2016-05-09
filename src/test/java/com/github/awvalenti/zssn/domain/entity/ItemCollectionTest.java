package com.github.awvalenti.zssn.domain.entity;

import static com.github.awvalenti.zssn.domain.entity.Item.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.domain.entity.ItemCollection;

public class ItemCollectionTest {

	private ItemCollection food5Water1Ammo2;
	private ItemCollection food3Water4;
	private ItemCollection food2Ammo2;

	@Before
	public void setUp() {
		food5Water1Ammo2 = ItemCollection.with(FOOD, 5, WATER, 1, AMMUNITION, 2);
		food3Water4 = ItemCollection.with(FOOD, 3, WATER, 4);
		food2Ammo2 = ItemCollection.with(FOOD, 2, AMMUNITION, 2);
	}

	@Test
	public void should_add_quantities() {
		food3Water4.add(food2Ammo2);
		assertThat(food3Water4, is(ItemCollection.with(FOOD, 5, WATER, 4, AMMUNITION, 2)));
	}

	@Test
	public void should_subtract_quantities() {
		food5Water1Ammo2.subtract(food2Ammo2);
		assertThat(food5Water1Ammo2, is(ItemCollection.with(FOOD, 3, WATER, 1)));
	}

}
