package com.github.awvalenti.zssn.resource;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.After;
import org.junit.Before;

import com.github.awvalenti.zssn.main.TestHttpServer;

public abstract class ResourceTest {

	private TestHttpServer server;

	protected WebTarget clientForPath(String path) {
		return ClientBuilder.newClient().target(server.getBaseUri()).path(path);
	}

	@Before
	public void setUp() throws Exception {
		server = new TestHttpServer();
		server.start();
	}

	@After
	public void tearDown() {
		server.stop();
	}

}
