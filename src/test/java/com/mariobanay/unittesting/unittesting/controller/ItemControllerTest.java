package com.mariobanay.unittesting.unittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mariobanay.unittesting.unittesting.business.ItemBusinessService;
import com.mariobanay.unittesting.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;

	@Test
	public void dummyItem_basic() throws Exception {
		
		// call "/dummy-item" response: application/json
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON); 
		
		// Executing request
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		
		// JSONAssert.assertEquals(expected, actual, false)
		// JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false)
		
	}
	
	@Test
	public void itemFromBusinesService_basic() throws Exception {
		
		when(businessService.retrieveHardcodedItem()).thenReturn(new Item (2, "Item 2", 10, 10));
		
		// call "/dummy-item" response: application/json
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON); 
		
		// Executing request
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id: 2, name: 'Item 2', price: 10, quantity: 10}"))
				.andReturn();
		
		// JSONAssert.assertEquals(expected, actual, false)
		// JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false)
		
	}
	
}
