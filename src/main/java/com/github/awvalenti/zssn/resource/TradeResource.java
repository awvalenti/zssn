package com.github.awvalenti.zssn.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("trades")
public class TradeResource {

	@POST
	public String post() {
		return "Ok";
	}

}
