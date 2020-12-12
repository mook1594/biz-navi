package com.mook1594.biznavi.common.model;

import java.math.BigDecimal;

import com.google.common.base.Objects;

import lombok.Getter;

public class Location {

	@Getter
	private final BigDecimal latitude;

	@Getter
	private final BigDecimal longitude;
	
	public Location(final String latitudeString, final String longitudeString) {
		this.latitude = new BigDecimal(latitudeString);
		this.longitude = new BigDecimal(longitudeString);
	}

	public Location(final BigDecimal latitude, final BigDecimal longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Location))
			return false;
		Location location = (Location)o;
		return Objects.equal(latitude, location.latitude) &&
			Objects.equal(longitude, location.longitude);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(latitude, longitude);
	}
}
