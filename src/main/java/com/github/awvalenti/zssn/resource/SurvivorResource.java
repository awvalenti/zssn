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

	private final SurvivorRepository survivorRepo;

	@Inject
	public SurvivorResource(SurvivorRepository survivorRepo) {
		this.survivorRepo = survivorRepo;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Survivor survivor) throws URISyntaxException {
		survivorRepo.add(survivor);
		return Response.created(new URI("survivors/" + survivor.getId())).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Survivor getOne(@PathParam("id") long id) {
		return survivorRepo.getOne(id);
	}

}
