package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.testsupport.testsuperclass.ResourceTest;
import com.github.awvalenti.zssn.testsupport.util.JsonUtils;

public class LocationResourceTest extends ResourceTest {

	@Before
	public void setUp() {
		postFirstHuman();
	}

	@Test
	public void should_update_location() {
		Response resp = clientForPath("survivors/1/location")
				.request()
				.put(Entity.json(JsonUtils.readAsString("location1.json")));

		assertThat(resp.getStatus(), is(201));

		String receivedJson = clientForPath("survivors/1/location")
				.request()
				.get(String.class);

		assertThat(JsonUtils.parse(receivedJson),
				is(JsonUtils.readAsJsonValue("location1.json")));
	}
}
