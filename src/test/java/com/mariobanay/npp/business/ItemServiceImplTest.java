package com.mariobanay.npp.business;

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

import com.mariobanay.npp.business.ItemServiceImpl;
import com.mariobanay.npp.data.ItemRepository;
import com.mariobanay.npp.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {

	private static final long EXPECTED_VALUE_0 = 100;
	private static final long EXPECTED_VALUE_1 = 400;
	private static final Item ITEM_0 = new Item(2, "Item 2", 10, 10);
	private static final Item ITEM_1 = new Item(3, "Item 3", 20, 20);

	@InjectMocks
	ItemServiceImpl business;

	@Mock
	ItemRepository repository = mock(ItemRepository.class);

	@Test
	public void retrieveAllItems_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(ITEM_0, ITEM_1));

		List<Item> items = business.retrieveAllItems();

		assertEquals(EXPECTED_VALUE_0, items.get(0).getValue());
		assertEquals(EXPECTED_VALUE_1, items.get(1).getValue());
	}
}
