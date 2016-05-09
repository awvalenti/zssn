package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.eclipsesource.json.JsonValue;
import com.github.awvalenti.zssn.main.TestHttpServer;
import com.github.awvalenti.zssn.testsupport.util.JsonUtils;

public class SurvivorResourceTest {

	private TestHttpServer server;

	@Before
	public void setUp() throws Exception {
		server = new TestHttpServer();
		server.start();
	}

	@Test
	public void should_add_survivor() {
		Response resp = ClientBuilder.newClient().target(server.getBaseUri())
				.path("survivors")
				.request()
				.post(Entity.json(JsonUtils.readAsString("survivor1.post.json")));

		assertThat(resp.getStatus(), is(201));

		JsonValue receivedJson = JsonUtils.parse(ClientBuilder.newClient().target(server.getBaseUri())
				.path("survivors")
				.path("1")
				.request()
				.get(String.class));

		assertThat(receivedJson, is(JsonUtils.readAsJsonValue("survivor1.get.json")));
	}

	@After
	public void tearDown() {
		server.stop();
	}

}
