package com.dave.inventoryservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dave.inventoryservice.entity.Inventory;
import com.dave.inventoryservice.repository.InventoryRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class InventoryController {

	private final InventoryRepository inventoryRepository;
	@Autowired
    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
	
	@GetMapping("/api/inventory/{productCode}")
	public ResponseEntity<Inventory> findInventoryByProductCode(@PathVariable("productCode") String productCode){
		Optional<Inventory> inventoryItem = inventoryRepository.findByProductCode(productCode);
        if(inventoryItem.isPresent()) {
            return new ResponseEntity<Inventory>(inventoryItem.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
        }
	}
}
