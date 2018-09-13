package com.mariobanay.npp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariobanay.npp.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
