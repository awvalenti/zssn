package com.github.awvalenti.zssn.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.awvalenti.zssn.domain.entity.Location;
import com.github.awvalenti.zssn.repository.LocationRepository;

public class LocationResource {

	private final LocationRepository repo;

	@Inject
	public LocationResource(LocationRepository repo) {
		this.repo = repo;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("survivorId") long survivorId, Location newLocation)
			throws URISyntaxException {
		repo.update(survivorId, newLocation);
		return Response.created(new URI("survivor/" + survivorId + "/location")).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Location getOne(@PathParam("survivorId") long survivorId) {
		return repo.getOne(survivorId);
	}

}
