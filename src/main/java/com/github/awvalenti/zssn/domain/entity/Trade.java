package com.github.awvalenti.zssn.domain.entity;

public class Trade {

	private long trader1Id;
	private long trader2Id;
	private ItemCollection offer1;
	private ItemCollection offer2;

	public Trade(long trader1Id, long trader2Id, ItemCollection offer1, ItemCollection offer2) {
		this.trader1Id = trader1Id;
		this.trader2Id = trader2Id;
		this.offer1 = offer1;
		this.offer2 = offer2;
	}

	Trade() {
	}

	public long getTrader1Id() {
		return trader1Id;
	}

	public void setTrader1Id(long trader1Id) {
		this.trader1Id = trader1Id;
	}

	public long getTrader2Id() {
		return trader2Id;
	}

	public void setTrader2Id(long trader2Id) {
		this.trader2Id = trader2Id;
	}

	public ItemCollection getOffer1() {
		return offer1;
	}

	public void setOffer1(ItemCollection offer1) {
		this.offer1 = offer1;
	}

	public ItemCollection getOffer2() {
		return offer2;
	}

	public void setOffer2(ItemCollection offer2) {
		this.offer2 = offer2;
	}

}
