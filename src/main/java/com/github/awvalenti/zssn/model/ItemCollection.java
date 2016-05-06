package com.github.awvalenti.zssn.model;

import java.util.Map;
import java.util.Map.Entry;

public class ItemCollection {

	private final Map<Item, Integer> amountsPerItem;

	public ItemCollection(Map<Item, Integer> amountsPerItem) {
		this.amountsPerItem = amountsPerItem;
	}

	public int getTotalPoints() {
		int total = 0;

		for (Entry<Item, Integer> entry : amountsPerItem.entrySet()) {
			total += entry.getKey().getPoints() * entry.getValue();
		}

		return total;
	}

}
