package com.github.awvalenti.zssn.domain.entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.awvalenti.zssn.config.serializer.ItemCollectionDeserializer;
import com.github.awvalenti.zssn.config.serializer.ItemCollectionSerializer;

@Entity
@JsonSerialize(using = ItemCollectionSerializer.class)
@JsonDeserialize(using = ItemCollectionDeserializer.class)
public class ItemCollection implements Iterable<ItemSlot> {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "itemcollection_id")
	private Set<ItemSlot> slots;

	/**
	 * Creates an ItemCollection with specified items and quantities. Usage:
	 * ItemCollection.with(item0, quantity0, item1, quantity1, item2, quantity2...)
	 *
	 * @param args
	 *            Item/quantity pairs
	 * @return the ItemCollection
	 */
	public static ItemCollection with(Object... args) {
		Set<ItemSlot> slots = new HashSet<>();

		for (int i = 0; i < args.length; i += 2) {
			Item key = (Item) args[i];
			Integer value = (Integer) args[i + 1];
			slots.add(new ItemSlot(key, value));
		}

		return new ItemCollection(slots);
	}

	public ItemCollection(Set<ItemSlot> slots) {
		this.slots = slots;
	}

	ItemCollection() {
	}

	public int getTotalPoints() {
		int total = 0;

		for (ItemSlot slot : slots) {
			total += slot.getPoints();
		}

		return total;
	}

	public void add(ItemCollection other) {
		doOperation(other, 1);
	}

	public void subtract(ItemCollection other) {
		doOperation(other, -1);
	}

	@Override
	public Iterator<ItemSlot> iterator() {
		// Using TreeSet so that items will always be on the same
		// order. This shouldn't be necessary, but it is because of
		// this: https://github.com/ralfstx/minimal-json/issues/65
		return new TreeSet<>(slots).iterator();
	}

	@Override
	public String toString() {
		return slots.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ItemCollection)) return false;

		ItemCollection o = (ItemCollection) other;

		// For unknown reasons, simply returning this.slots.equals(o.slots) doesn't work.
		// So, we do the work manually.

		for (Item item : Item.values()) {
			if (this.getQuantity(item) != o.getQuantity(item)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		return slots.hashCode();
	}

	private void doOperation(ItemCollection other, int factor) {
		for (ItemSlot otherSlot : other.slots) {
			Item item = otherSlot.getItem();

			int myQuantity = this.getQuantity(item);
			int theirQuantity = otherSlot.getQuantity();

			this.setQuantity(item, myQuantity + factor * theirQuantity);
		}
	}

	private int getQuantity(Item item) {
		for (ItemSlot slot : slots) {
			if (slot.getItem().equals(item)) {
				return slot.getQuantity();
			}
		}

		return 0;
	}

	private void setQuantity(Item item, int quantity) {
		for (ItemSlot slot : slots) {
			if (slot.getItem().equals(item)) {
				if (quantity == 0) {
					slots.remove(slot);
				} else {
					slot.setQuantity(quantity);
				}
				return;
			}
		}

		slots.add(new ItemSlot(item, quantity));
	}

}
