package com.github.awvalenti.zssn.config;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import com.github.awvalenti.zssn.config.ApplicationResourceConfig;

public class TestHttpServer {

	private HttpServer server;

	public final String getBaseUri() {
		return "http://localhost:8081/zssn/";
	}

	public void start() {
		if (server != null) throw new IllegalStateException("Already started");

		server = GrizzlyHttpServerFactory.createHttpServer(
				URI.create(getBaseUri()),
				new ApplicationResourceConfig());
	}

	public void stop() {
		server.shutdownNow();
	}

}
