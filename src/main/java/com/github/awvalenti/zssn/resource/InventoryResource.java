package com.github.awvalenti.zssn.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.awvalenti.zssn.domain.entity.ItemCollection;
import com.github.awvalenti.zssn.domain.service.InventoryService;
import com.github.awvalenti.zssn.domain.service.exception.ZombieCannotCheckRepository;

public class InventoryResource {

	private final InventoryService service;

	@Inject
	public InventoryResource(InventoryService service) {
		this.service = service;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOne(@PathParam("survivorId") long survivorId) {
		try {
			ItemCollection inventory = service.checkInventory(survivorId);
			return Response.ok(inventory).build();
		} catch (ZombieCannotCheckRepository e) {
			return Response.status(403).build();
		}
	}


}
