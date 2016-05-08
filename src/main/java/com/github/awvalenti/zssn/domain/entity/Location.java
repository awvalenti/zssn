package com.github.awvalenti.zssn.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Location {

	@Column(nullable = false)
	private Double latitude;

	@Column(nullable = false)
	private Double longitude;

	public Location(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	Location() {
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (!(otherObject instanceof Location)) return false;
		Location other = (Location) otherObject;
		return this.latitude.equals(other.latitude) && this.longitude.equals(other.longitude);
	}

	@Override
	public int hashCode() {
		return (int) (latitude * 512 + longitude);
	}

}
