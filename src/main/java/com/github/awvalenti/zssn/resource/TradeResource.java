package com.github.awvalenti.zssn.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.github.awvalenti.zssn.domain.service.TradeService;

@Path("trades")
public class TradeResource {

	private final TradeService tradeService;

	@Inject
	public TradeResource(TradeService tradeService) {
		this.tradeService = tradeService;
	}

	@POST
	public String post() {
		return tradeService == null ? null : "Ok";
	}

}
