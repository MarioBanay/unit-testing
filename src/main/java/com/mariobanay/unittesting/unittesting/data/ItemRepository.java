package com.mariobanay.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariobanay.unittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
