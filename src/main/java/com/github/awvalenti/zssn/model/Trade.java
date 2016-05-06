package com.github.awvalenti.zssn.model;

public class Trade {

	private final ItemCollection offer1;
	private final ItemCollection offer2;

	public Trade(ItemCollection offer1, ItemCollection offer2) {
		this.offer1 = offer1;
		this.offer2 = offer2;
	}

	public boolean isValid() {
		return offer1.getTotalPoints() == offer2.getTotalPoints();
	}

}
