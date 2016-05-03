package com.github.awvalenti.zssn.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.github.awvalenti.zssn.model.Survivor;
import com.github.awvalenti.zssn.repository.LocationRepository;
import com.github.awvalenti.zssn.repository.SurvivorRepository;

@Path("/survivors")
public class SurvivorResource {

	private final SurvivorRepository repo;
	private final LocationRepository locationRepo;

	public SurvivorResource(SurvivorRepository survivorRepo, LocationRepository locationRepo) {
		this.repo = survivorRepo;
		this.locationRepo = locationRepo;
	}

	@POST
	public void post(Survivor survivor) {
		repo.add(survivor);
		locationRepo.add(survivor.getLocation());
	}

	@GET
	public Survivor getOne(long id) {
		return repo.getOne(id);
	}

}
