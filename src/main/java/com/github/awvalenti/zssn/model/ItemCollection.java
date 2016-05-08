package com.github.awvalenti.zssn.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class ItemCollection {

	@Id
	@GeneratedValue
	private Long id;

	@Transient
	private final Map<Item, Integer> amountsPerItem;

	@Column(nullable = false)
	@OneToMany
	@JoinColumn(name = "itemcollection_id")
	private final Set<ItemAmount> amounts;

	/**
	 * Creates an ItemCollection with specified items and quantities. Usage:
	 * ItemCollection.with(item0, quantity0, item1, quantity1, item2, quantity2...)
	 *
	 * @param args
	 *            Item/quantity pairs
	 * @return the ItemCollection
	 */
	public static ItemCollection with(Object... args) {
		Map<Item, Integer> map = new HashMap<>();

		for (int i = 0; i < args.length; i += 2) {
			assertParameter(args[i], Item.class);
			assertParameter(args[i + 1], Integer.class);

			Item key = (Item) args[i];
			Integer value = (Integer) args[i + 1];
			map.put(key, value);
		}

		return new ItemCollection(map);
	}

	private static void assertParameter(Object object, Class<?> clazz) {
		if (!clazz.isInstance(object)) {
			throw new IllegalArgumentException(object + " should be instance of " + clazz
					+ ", but its class is " + object.getClass() + ".");
		}
	}

	private ItemCollection(Map<Item, Integer> amountsPerItem) {
		this.amountsPerItem = new HashMap<>(amountsPerItem);
		amounts = new HashSet<>();

		// If map does not contain all items, adds absent items with zero amount
		Arrays.stream(Item.values()).forEach(item -> this.amountsPerItem.putIfAbsent(item, 0));

		this.amountsPerItem.forEach((item, quantity) -> amounts.add(new ItemAmount(item, quantity)));
	}

	public int getTotalPoints() {
		int total = 0;

		for (Entry<Item, Integer> entry : amountsPerItem.entrySet()) {
			total += entry.getKey().getPoints() * entry.getValue();
		}

		return total;
	}

	public void add(ItemCollection other) {
		other.amountsPerItem.forEach((item, amountOther) -> {
			this.amountsPerItem.put(item, this.amountsPerItem.get(item) + amountOther);
		});
	}

	public void subtract(ItemCollection other) {
		other.amountsPerItem.forEach((item, amountOther) -> {
			this.amountsPerItem.put(item, this.amountsPerItem.get(item) - amountOther);
		});
	}

	@Override
	public String toString() {
		return amountsPerItem.toString();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ItemCollection)) return false;
		return amountsPerItem.equals(((ItemCollection) other).amountsPerItem);
	}

	@Override
	public int hashCode() {
		return amountsPerItem.hashCode();
	}

}
