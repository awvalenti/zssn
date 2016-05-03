package com.github.awvalenti.zssn.model;

public class Location {

	private final double latitude;
	private final double longitude;

	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (!(otherObject instanceof Location)) return false;
		Location other = (Location) otherObject;
		return this.latitude == other.latitude && this.longitude == other.longitude;
	}

	@Override
	public int hashCode() {
		return (int) (latitude * 512 + longitude);
	}

}
