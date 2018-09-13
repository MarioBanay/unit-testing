package com.mariobanay.npp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mariobanay.npp.business.ItemServiceImpl;
import com.mariobanay.npp.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemServiceImpl businesService;
	
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
