package com.github.awvalenti.zssn.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.github.awvalenti.zssn.domain.enumeration.Gender;

@Entity
public class Survivor {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Integer age;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(nullable = false)
	private Boolean zombie;

	@Column(nullable = false)
	private Location location;

	@JoinColumn(nullable = false)
	@OneToOne(cascade = CascadeType.PERSIST)
	private ItemCollection inventory;

	public Survivor() {
	}

	public Survivor(long id) {
		setId(id);
		setZombie(false);
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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

	public Boolean isZombie() {
		return zombie;
	}

	public void setZombie(Boolean zombie) {
		this.zombie = zombie;
	}

}