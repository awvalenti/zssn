package com.github.awvalenti.zssn.testsupport.httpserver;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.github.awvalenti.zssn.config.DependencyInjectionBinder;

public class TestHttpServer {

	private HttpServer server;

	public final String getBaseUri() {
		return "http://localhost:8081/zssn/";
	}

	public void start() {
		if (server != null) throw new IllegalStateException("Already started");

		server = GrizzlyHttpServerFactory.createHttpServer(
				URI.create(getBaseUri()),
				new ResourceConfig().register(new DependencyInjectionBinder()).packages(
						"com.github.awvalenti.zssn.resource"));

	}

	public void stop() {
		server.shutdownNow();
	}

}
