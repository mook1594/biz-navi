package com.mook1594.biznavi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BizNaviLocationInfoDto {

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
}
