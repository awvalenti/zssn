package com.github.awvalenti.zssn.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.github.awvalenti.zssn.domain.entity.Trade;
import com.github.awvalenti.zssn.domain.service.TradeService;
import com.github.awvalenti.zssn.domain.service.exception.InvalidTrade;

@Path("trades")
public class TradeResource {

	private final TradeService service;

	@Inject
	public TradeResource(TradeService service) {
		this.service = service;
	}

	@POST
	public Response post(Trade trade) {
		try {
			service.trade(trade);
			return Response.ok().build();
		} catch (InvalidTrade e) {
			return Response.status(403).build();
		}
	}

}
