package com.github.awvalenti.zssn.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationResourceConfig extends ResourceConfig {

	public ApplicationResourceConfig() {
		register(new ApplicationBinder())
				.packages("com.github.awvalenti.zssn.resource");
	}
}
