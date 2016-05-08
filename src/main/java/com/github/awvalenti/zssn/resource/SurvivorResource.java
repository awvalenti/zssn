package com.github.awvalenti.zssn.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
	public void post(Survivor survivor) {
		survivorRepo.add(survivor);
	}

	@GET
	@Path("{id}")
	public Survivor getOne(@PathParam("id") long id) {
		return survivorRepo.getOne(id);
	}

}
