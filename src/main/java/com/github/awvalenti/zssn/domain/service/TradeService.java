package com.github.awvalenti.zssn.domain.service;

import com.github.awvalenti.zssn.domain.entity.ItemCollection;
import com.github.awvalenti.zssn.domain.entity.Survivor;

public class TradeService {

	public final boolean validate(Survivor trader1, ItemCollection offer1, Survivor trader2,
			ItemCollection offer2) {
		return !trader1.isZombie() && !trader2.isZombie()
				&& offer1.getTotalPoints() == offer2.getTotalPoints();
	}

	public void trade(Survivor trader1, ItemCollection offer1, Survivor trader2,
			ItemCollection offer2) {
		if (!validate(trader1, offer1, trader2, offer2)) {
			throw new IllegalArgumentException("Invalid trade");
		}

		trader1.getInventory().subtract(offer1);
		trader2.getInventory().subtract(offer2);

		trader1.getInventory().add(offer2);
		trader2.getInventory().add(offer1);
	}

}
