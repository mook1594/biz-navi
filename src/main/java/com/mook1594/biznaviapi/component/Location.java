package com.mook1594.biznaviapi.component;

import java.math.BigDecimal;

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
}
