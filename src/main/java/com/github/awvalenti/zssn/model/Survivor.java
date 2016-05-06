package com.github.awvalenti.zssn.model;


public class Survivor {

	private Long id;
	private String name;
	private int age;
	private Gender gender;
	private boolean zombie;
	private Location location;
	private ItemCollection inventory;

	public Survivor() {
	}

	public Survivor(long id) {
		setId(id);
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

	public ItemCollection getInventory() {
		return inventory;
	}

	public void setInventory(ItemCollection inventory) {
		this.inventory = inventory;
	}

	public boolean isZombie() {
		return zombie;
	}

	public void setZombie(boolean zombie) {
		this.zombie = zombie;
	}

}
