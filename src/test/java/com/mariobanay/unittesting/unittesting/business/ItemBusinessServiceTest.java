package com.mariobanay.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mariobanay.unittesting.unittesting.data.ItemRepository;
import com.mariobanay.unittesting.unittesting.data.SomeDataService;
import com.mariobanay.unittesting.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	
	@InjectMocks
	ItemBusinessService business;
	
	@Mock
	ItemRepository repository = mock(ItemRepository.class);

	@Test
	public void retrieveAllItems_basic() {
		when(repository.findAll()).thenReturn(
				Arrays.asList(new Item (2, "Item 2", 10, 10),
						new Item (3, "Item 3", 20, 20)));
		
		List<Item> items = business.retrieveAllItems();
		
		assertEquals(100, items.get(0).getValue());
		assertEquals(400, items.get(1).getValue());
	}
}
