package com.mariobanay.unittesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mariobanay.unittesting.unittesting.business.ItemBusinessService;
import com.mariobanay.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService businesService;
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/item-from-business-service")
	public Item itemFromBusinesService() {
		return businesService.retrieveHardcodedItem();
	}
	
	@GetMapping("/all-items-from-database")
	public List<Item> retrieveAllItems(){
		return businesService.retrieveAllItems();
	}
}
