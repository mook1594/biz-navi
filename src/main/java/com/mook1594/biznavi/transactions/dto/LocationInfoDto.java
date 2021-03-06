package com.mook1594.biznavi.transactions.dto;

import java.beans.Transient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mook1594.biznavi.common.model.Location;

import lombok.Builder;
import lombok.Getter;


@JsonDeserialize(builder = LocationInfoDto.LocationInfoDtoBuilder.class)
public class LocationInfoDto {

	@Getter private final String datetime;
	@Getter private final double remainDist;
	@Getter private final String lng;
	@Getter private final String lat;

	@Builder
	public LocationInfoDto(
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
