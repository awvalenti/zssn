package com.github.awvalenti.zssn.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.awvalenti.zssn.domain.entity.Survivor;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

@Path("survivors")
public class SurvivorResource {

	private final SurvivorRepository repo;

	@Inject
	public SurvivorResource(SurvivorRepository repo) {
		this.repo = repo;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Survivor survivor) throws URISyntaxException {
		repo.add(survivor);
		return Response.created(new URI("survivors/" + survivor.getId())).build();
	}

	@GET
	@Path("{survivorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Survivor getOne(@PathParam("survivorId") long id) {
		return repo.getOne(id);
	}

	@Path("{survivorId}/location")
	public Class<LocationResource> location() {
		return LocationResource.class;
	}

	@Path("{survivorId}/inventory")
	public Class<InventoryResource> inventory() {
		return InventoryResource.class;
	}

}
