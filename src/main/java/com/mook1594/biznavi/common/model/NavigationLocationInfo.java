package com.mook1594.biznavi.common.model;

import java.math.BigDecimal;

public class NavigationLocationInfo {

	private final String transId;
	private final String dateTime;
	private final BigDecimal remainDistance;
	private final String startName;
	private final String goalName;
	private final BigDecimal lng;
	private final BigDecimal lat;

	/**
	 * @param transId 트랜젝션 ID
	 * @param dateTime 데이터 시간
	 * @param remainDistance 남은 거리
	 * @param startName 출발지
	 * @param goalName 도착지
	 * @param lat 위도
	 * @param lng 경도
	 */
	public NavigationLocationInfo(
		final String transId,
		final String dateTime,
		final BigDecimal remainDistance,
		final String startName,
		final String goalName,
		final BigDecimal lat,
		final BigDecimal lng
	){
		this.transId = transId;
		this.dateTime = dateTime;
		this.remainDistance = remainDistance;
		this.startName = startName;
		this.goalName = goalName;
		this.lat = lat;
		this.lng = lng;
	}

	/**
	 * @param transId 트랜젝션 ID
	 * @param dateTime 데이터 시간
	 * @param remainDistance 남은 거리
	 * @param lat 위도
	 * @param lng 경도
	 */
	public NavigationLocationInfo(
		final String transId,
		final String dateTime,
		final BigDecimal remainDistance,
		final BigDecimal lat,
		final BigDecimal lng
	){
		this.transId = transId;
		this.dateTime = dateTime;
		this.remainDistance = remainDistance;
		this.lat = lat;
		this.lng = lng;
		this.startName = null;
		this.goalName = null;
	}

	public Location getLocation() {
		return new Location(lat, lng);
	}
}
