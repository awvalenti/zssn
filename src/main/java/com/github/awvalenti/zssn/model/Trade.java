package com.github.awvalenti.zssn.model;

public class Trade {

	private final ItemCollection offer1;
	private final ItemCollection offer2;
	private final Survivor trader1;
	private final Survivor trader2;

	public Trade(Survivor trader1, ItemCollection offer1, Survivor trader2, ItemCollection offer2) {
		this.trader1 = trader1;
		this.offer1 = offer1;
		this.trader2 = trader2;
		this.offer2 = offer2;
	}

	public boolean isValid() {
		return !trader1.isZombie() && !trader2.isZombie()
				&& offer1.getTotalPoints() == offer2.getTotalPoints();
	}

}
