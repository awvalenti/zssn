package com.github.awvalenti.zssn.domain.service;

import javax.inject.Inject;

import com.github.awvalenti.zssn.domain.entity.ItemCollection;
import com.github.awvalenti.zssn.domain.entity.Survivor;
import com.github.awvalenti.zssn.domain.entity.Trade;
import com.github.awvalenti.zssn.domain.service.exception.InvalidTrade;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

public class TradeService {

	private final SurvivorRepository repo;

	@Inject
	public TradeService(SurvivorRepository repo) {
		this.repo = repo;
	}

	public final boolean validate(Survivor trader1, ItemCollection offer1, Survivor trader2,
			ItemCollection offer2) {
		return !trader1.isZombie() && !trader2.isZombie()
				&& offer1.getTotalPoints() == offer2.getTotalPoints();
	}

	public void trade(Trade trade) throws InvalidTrade {
		Survivor trader1 = repo.getOne(trade.getTrader1Id());
		Survivor trader2 = repo.getOne(trade.getTrader2Id());
		ItemCollection offer1 = trade.getOffer1();
		ItemCollection offer2 = trade.getOffer2();

		if (!validate(trader1, offer1, trader2, offer2)) {
			throw new InvalidTrade();
		}

		trader1.getInventory().subtract(offer1);
		trader2.getInventory().subtract(offer2);

		trader1.getInventory().add(offer2);
		trader2.getInventory().add(offer1);
	}

}
