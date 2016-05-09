package com.github.awvalenti.zssn.testsupport.testsuperclass;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;

import com.github.awvalenti.zssn.main.TestHttpServer;
import com.github.awvalenti.zssn.testsupport.util.JsonUtils;

public abstract class ResourceTest {

	private TestHttpServer server;

	@Before
	public final void startServer() throws Exception {
		server = new TestHttpServer();
		server.start();
	}

	@After
	public final void stopServer() {
		server.stop();
	}

	protected final WebTarget clientForPath(String path) {
		return ClientBuilder.newClient().target(server.getBaseUri()).path(path);
	}

	protected final Response postFirstHuman() {
		return clientForPath("survivors")
				.request()
				.post(Entity.json(JsonUtils.readAsString("survivor1.post.json")));
	}

	protected final Response postSecondHuman() {
		return clientForPath("survivors")
				.request()
				.post(Entity.json(JsonUtils.readAsString("survivor2.post.json")));
	}

	protected final Response postFirstZombie() {
		return clientForPath("survivors")
				.request()
				.post(Entity.json(JsonUtils.readAsString("survivor3.post.json")));
	}

}
