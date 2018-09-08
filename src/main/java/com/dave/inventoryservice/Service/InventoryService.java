package com.dave.inventoryservice.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dave.inventoryservice.entity.Inventory;
import com.dave.inventoryservice.repository.InventoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class InventoryService {

	private final InventoryRepository repo;
	
	@Autowired
	public InventoryService(InventoryRepository repo) {
		this.repo = repo;
	}
	
	public Iterable<Inventory> findAllInventory() {
        return repo.findAll();
    }
 
    public Optional<Inventory> findByProductCode(String productCode) {
        return repo.findByProductCode(productCode);
    }
}
