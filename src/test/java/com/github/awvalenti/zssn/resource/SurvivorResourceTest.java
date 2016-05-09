package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.github.awvalenti.zssn.testsupport.util.JsonUtils;

public class SurvivorResourceTest extends ResourceTest {

	@Test
	public void should_add_survivor() {
		Response resp = clientForPath("survivors")
				.request()
				.post(Entity.json(JsonUtils.readAsString("survivor1.post.json")));

		assertThat(resp.getStatus(), is(201));

		String receivedJson = clientForPath("survivors/1")
			.request()
			.get(String.class);

		assertThat(JsonUtils.parse(receivedJson),
				is(JsonUtils.readAsJsonValue("survivor1.get.json")));
	}

}
