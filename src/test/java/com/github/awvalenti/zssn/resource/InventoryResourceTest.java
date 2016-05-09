package com.github.awvalenti.zssn.resource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import com.github.awvalenti.zssn.testsupport.testsuperclass.ResourceTest;
import com.github.awvalenti.zssn.testsupport.util.JsonUtils;

public class InventoryResourceTest extends ResourceTest {

	@Before
	public void setUp() {
		postFirstHuman();
		postSecondHuman();
		postFirstZombie();
	}

	@Test
	public void human_survivor_should_be_able_to_check_inventory() {
		String receivedJson = clientForPath("survivors/1/inventory")
				.request()
				.get(String.class);

		assertThat(JsonUtils.parse(receivedJson), is(JsonUtils.readAsJsonValue("inventory1.json")));
	}

	@Test
	public void zombie_should_be_unable_to_check_inventory() {
		 Response resp = clientForPath("survivors/3/inventory")
				.request()
				.get();

		assertThat(resp.getStatus(), is(403));
		assertThat(resp.getLength(), is(0));
	}

}
