package com.github.awvalenti.zssn.model;

public enum Item {

	AMMUNITION(1),

	MEDICATION(2),

	FOOD(3),

	WATER(4),
	;

	private final int points;

	private Item(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

}
