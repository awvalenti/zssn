package com.github.awvalenti.zssn.model;

import java.util.Set;

public class Survivor {

	private Long id;
	private String name;
	private int age;
	private Gender gender;
	private Location location;
	private Set<Item> inventory;

	public Survivor(String name, int age, Gender gender, Location location, Set<Item> inventory) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.inventory = inventory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Item> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Item> inventory) {
		this.inventory = inventory;
	}

}
