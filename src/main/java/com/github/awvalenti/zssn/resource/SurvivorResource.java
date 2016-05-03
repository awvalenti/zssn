package com.github.awvalenti.zssn.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.github.awvalenti.zssn.model.Survivor;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

@Path("/survivors")
public class SurvivorResource {

	private final SurvivorRepository survivorRepo;

	public SurvivorResource(SurvivorRepository survivorRepo) {
		this.survivorRepo = survivorRepo;
	}

	@POST
	public void post(Survivor survivor) {
		survivorRepo.add(survivor);
	}

	@GET
	public Survivor getOne(long id) {
		return survivorRepo.getOne(id);
	}

}
