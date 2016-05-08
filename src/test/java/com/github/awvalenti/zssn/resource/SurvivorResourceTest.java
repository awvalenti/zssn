package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

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
		String a = ClientBuilder.newClient().target(server.getBaseUri())
				.path("survivors")
				.request()
				.post(Entity.json(""
						+ "{\"name\":\"John Doe\",\"age\":21,\"gender\":\"MALE\",\"zombie\":false,\"location\":null,\"inventory\":[]}"
						+ ""), String.class);

		System.out.println("A: " + a);

		String string = ClientBuilder.newClient().target(server.getBaseUri())
				.path("survivors")
				.path("1")
				.request()
				.get(String.class);

		assertThat(string, is("{\"name\": \"Teste\",\"age\": 15}"));
	}

	@After
	public void tearDown() {
		server.stop();
	}

}
