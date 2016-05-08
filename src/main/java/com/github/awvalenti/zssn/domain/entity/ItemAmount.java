package com.github.awvalenti.zssn.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemAmount {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Item item;

	@Column(nullable = false)
	private Integer quantity;

	public ItemAmount(Item item, Integer quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	ItemAmount() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public int getPoints() {
		return item.getPoints() * quantity;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ItemAmount)) return false;

		ItemAmount otherAmount = (ItemAmount) other;
		return this.item.equals(otherAmount.item) && this.quantity.equals(otherAmount.quantity);
	}

	@Override
	public int hashCode() {
		return item.hashCode() * 4 + quantity;
	}

	@Override
	public String toString() {
		return item.toString() + ":" + quantity;
	}

}