package com.mariobanay.npp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mariobanay.npp.data.ItemRepository;
import com.mariobanay.npp.model.Item;

@Component
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository repository;

/*	public Item retrieveHardcodedItem() {
		return new Item(1, "Ball", 10, 100);
	}*/
	
	public List<Item> retrieveAllItems(){
		List<Item> items = repository.findAll();
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;	
	}
}
