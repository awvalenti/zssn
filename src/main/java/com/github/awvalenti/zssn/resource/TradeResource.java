package com.github.awvalenti.zssn.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.github.awvalenti.zssn.service.TradeService;

@Path("trades")
public class TradeResource {

	@Inject
	private TradeService tradeService;

	@POST
	public String post() {
		return tradeService == null ? null : "Ok";
	}

}
