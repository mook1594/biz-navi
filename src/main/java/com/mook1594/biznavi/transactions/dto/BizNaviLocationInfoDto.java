package com.mook1594.biznavi.transactions.dto;

import com.mook1594.biznavi.common.model.Location;

import lombok.Builder;
import lombok.Getter;


public class BizNaviLocationInfoDto {
	@Getter
	private final String datetime;
	private final String lat;
	private final String lng;

	@Builder
	public BizNaviLocationInfoDto(
		final String datetime,
		final String lat,
		final String lng
	) {
		this.datetime = datetime;
		this.lat = lat;
		this.lng = lng;
	}

	public Location getLocation() {
		return new Location(lat, lng);
	}
}
