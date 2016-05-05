package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.github.awvalenti.zssn.httpserver.TestHttpServer;

public class TradeResourceTest {

	@Test
	public void should_be_able_to_trade() {
		TestHttpServer server = new TestHttpServer();

		server.start();

		String responseBody = ClientBuilder.newClient().target(server.getBaseUri())
				.path("trades")
				.request(MediaType.APPLICATION_JSON)
				.post(Entity.text("test"))
				.readEntity(String.class);

		assertThat(responseBody, is("Ok"));

		server.stop();
	}

}
