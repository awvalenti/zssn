package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.github.awvalenti.zssn.testsupport.testsuperclass.ResourceTest;
import com.github.awvalenti.zssn.testsupport.util.JsonUtils;

public class SurvivorResourceTest extends ResourceTest {

	@Test
	public void should_add_survivor() {
		Response resp = postFirstHuman();

		assertThat(resp.getStatus(), is(201));

		String receivedJson = clientForPath("survivors/1")
			.request()
			.get(String.class);

		assertThat(JsonUtils.parse(receivedJson),
				is(JsonUtils.readAsJsonValue("survivor1.get.json")));
	}

}
