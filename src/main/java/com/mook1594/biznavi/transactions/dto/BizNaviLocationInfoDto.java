package com.mook1594.biznavi.transactions.dto;

import java.beans.Transient;

import com.mook1594.biznavi.common.model.Location;

import lombok.Builder;
import lombok.Getter;


public class BizNaviLocationInfoDto {

	@Getter private final String datetime;
	@Getter private final double remainDist;
	@Getter private final String lng;
	@Getter private final String lat;

	@Builder
	public BizNaviLocationInfoDto(
		final String datetime,
		final double remainDist,
		final String lat,
		final String lng
	) {
		this.datetime = datetime;
		this.remainDist = remainDist;
		this.lat = lat;
		this.lng = lng;
	}

	@Transient
	public Location getLocation() {
		return new Location(lat, lng);
	}
}
