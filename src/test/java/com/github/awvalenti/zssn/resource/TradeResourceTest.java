package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.testsupport.testsuperclass.ResourceTest;
import com.github.awvalenti.zssn.testsupport.util.JsonUtils;

public class TradeResourceTest extends ResourceTest {

	@Before
	public void setUp() {
		postFirstHuman();
		postSecondHuman();
	}

	@Test
	public void should_trade_items() {
		Response resp = clientForPath("trades")
				.request()
				.post(Entity.json(JsonUtils.readAsString("trade1.post.json")));

		assertThat(resp.getStatus(), is(200));

		String receivedJson1 = clientForPath("survivors/1/inventory")
				.request()
				.get(String.class);

		assertThat(JsonUtils.parse(receivedJson1),
				is(JsonUtils.readAsJsonValue("trade1.inventory1.json")));

		String receivedJson2 = clientForPath("survivors/2/inventory")
				.request()
				.get(String.class);

		assertThat(JsonUtils.parse(receivedJson2),
				is(JsonUtils.readAsJsonValue("trade1.inventory2.json")));
	}

}
