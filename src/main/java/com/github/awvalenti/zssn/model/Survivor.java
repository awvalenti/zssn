package com.github.awvalenti.zssn.model;

public class Survivor {

	private Long id;
	private String name;
	private int age;
	private Gender gender;
	private Location location;

	public Survivor(String name, int age, Gender gender, Location location) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.location = location;
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

}
