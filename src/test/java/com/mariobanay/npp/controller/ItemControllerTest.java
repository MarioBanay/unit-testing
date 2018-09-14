package com.mariobanay.npp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mariobanay.npp.business.ItemServiceImpl;
import com.mariobanay.npp.controller.ItemController;
import com.mariobanay.npp.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	private static final Item ITEM_0 = new Item(2, "Item 2", 10, 10);
	private static final Item ITEM_1 = new Item(3, "Item 3", 20, 20);
	private static final String JSON_ARRAY = "[{id: 2, name: 'Item 2', price: 10, quantity: 10},{id: 3, name: 'Item 3', price: 20, quantity: 20}]";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemServiceImpl businessService;

	@Test
	public void dummyItem_basic() throws Exception {

		// call "/dummy-item" response: application/json
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);

		// Executing request
		mockMvc.perform(request)
				.andExpect(status()
				.isOk())
				.andExpect(content()
				.json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
	}

	@Test
	public void retrieveAllItems_basic() throws Exception {

		when(businessService.retrieveAllItems())
				.thenReturn(Arrays.asList(ITEM_0, ITEM_1));

		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)
				.andExpect(status()
				.isOk())
				.andExpect(content()
				.json(JSON_ARRAY))
				.andReturn();

		// JSONAssert.assertEquals(expected, actual, false)
		// JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false)

	}

}
