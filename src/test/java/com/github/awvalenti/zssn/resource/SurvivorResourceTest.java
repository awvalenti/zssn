package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.config.TestHttpServer;

public class SurvivorResourceTest {

	private TestHttpServer server;

	@Before
	public void setUp() throws Exception {
		server = new TestHttpServer();
		server.start();
	}

	@Test
	public void should_add_survivor() {
		ClientBuilder.newClient().target(server.getBaseUri())
				.path("survivors")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.text("test"));

		String string = ClientBuilder.newClient().target(server.getBaseUri())
				.path("survivors")
				.path("1")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);

		assertThat(string, is("{}"));
	}

	@After
	public void tearDown() {
		server.stop();
	}

}
