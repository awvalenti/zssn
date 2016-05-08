package com.github.awvalenti.zssn.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	public void post(Survivor survivor) {
		survivorRepo.add(survivor);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Survivor getOne(@PathParam("id") long id) {
		return survivorRepo.getOne(id);
	}

}
