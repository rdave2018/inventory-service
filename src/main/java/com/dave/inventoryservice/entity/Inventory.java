package com.dave.inventoryservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="inventory")
public class Inventory {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@Column(nullable= false)
	public String productCode;
	@Column
	public String availableQuantity;
}
