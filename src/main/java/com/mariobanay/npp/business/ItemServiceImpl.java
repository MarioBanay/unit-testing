package com.mariobanay.npp.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mariobanay.npp.business.exceptions.NoItemException;
import com.mariobanay.npp.data.ItemRepository;
import com.mariobanay.npp.model.Item;

@Component
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository repository;

	public Item retrieveHardcodedItem() {
		System.out.println("Inside retrieveHardcodedItem");
		return new Item(1, "Ball", 10, 100);
	}
	
	public List<Item> retrieveAllItems(){
		List<Item> items = repository.findAll();
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		
		System.out.println("Inside retrieveAllItems");
		
		return items;	
	}
	
	@SuppressWarnings("rawtypes")
	public Optional findById(Integer id) throws NoItemException{
	
		Optional item = repository.findById(id);
		
		if (!item.isPresent()) {
			throw new NoItemException("Exception: ne postoji item s trazenim id");
		}
		
		return item;
	}
}
