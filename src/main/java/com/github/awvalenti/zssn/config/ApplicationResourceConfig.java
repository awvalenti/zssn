package com.github.awvalenti.zssn.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class ApplicationResourceConfig extends ResourceConfig {

	public ApplicationResourceConfig() {
		register(new ApplicationBinder());
		register(new JacksonJaxbJsonProvider());
		register(new DebugExceptionMapper());
		packages("com.github.awvalenti.zssn.resource");
	}

}
