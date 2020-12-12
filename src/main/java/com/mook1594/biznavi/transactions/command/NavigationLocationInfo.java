package com.mook1594.biznavi.transactions.command;

import java.math.BigDecimal;

import com.mook1594.biznavi.common.model.Location;

import lombok.Getter;

@Getter
public class NavigationLocationInfo {

	private final String transId;
	private final String dateTime;
	private final BigDecimal totalDistance;
	private final BigDecimal remainDistance;
	private final String startName;
	private final String goalName;
	private final BigDecimal lng;
	private final BigDecimal lat;

	/** 네비 시작 데이터
	 * @param transId 트랜젝션 ID
	 * @param dateTime 데이터 시간
	 * @param totalDistance 총거리
	 * @param startName 출발지
	 * @param goalName 도착지
	 * @param lat 위도
	 * @param lng 경도
	 */
	public NavigationLocationInfo(
		final String transId,
		final String dateTime,
		final double totalDistance,
		final String startName,
		final String goalName,
		final String lat,
		final String lng
	){
		this.transId = transId;
		this.dateTime = dateTime;
		this.totalDistance = BigDecimal.valueOf(totalDistance);
		this.remainDistance = BigDecimal.ZERO;
		this.startName = startName;
		this.goalName = goalName;
		this.lat = new BigDecimal(lat);
		this.lng = new BigDecimal(lng);
	}

	/** 네비 중간, 종료 데이터
	 * @param transId 트랜젝션 ID
	 * @param dateTime 데이터 시간
	 * @param remainDistance 남은 거리
	 * @param lat 위도
	 * @param lng 경도
	 */
	public NavigationLocationInfo(
		final String transId,
		final String dateTime,
		final double remainDistance,
		final String lat,
		final String lng
	){
		this.transId = transId;
		this.dateTime = dateTime;
		this.totalDistance = BigDecimal.ZERO;
		this.remainDistance = BigDecimal.valueOf(remainDistance);
		this.lat = new BigDecimal(lat);
		this.lng = new BigDecimal(lng);
		this.startName = null;
		this.goalName = null;
	}

	public Location getLocation() {
		return new Location(lat, lng);
	}


}
