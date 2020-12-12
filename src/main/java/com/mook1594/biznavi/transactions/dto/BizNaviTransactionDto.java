package com.mook1594.biznavi.transactions.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.collect.Lists;
import com.mook1594.biznavi.common.model.Location;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "transaction")
@Getter
public class BizNaviTransactionDto {

	@Id
	private String id;
	private final String stName;
	private final String glName;
	private final double dist;
	private final String glLat;
	private final String glLng;
	private final boolean finish;

	final List<BizNaviLocationInfoDto> locationInfos;

	/**
	 * @param transactionId transaction ID
	 * @param startPlaceName 출발지 명
	 * @param goalPlaceName 도착지 명
	 * @param totalDistance 총 거리(m)
	 * @param transactionFinished transaction 종료 여부
	 */
	@Builder
	public BizNaviTransactionDto(
		final String transactionId,
		final String startPlaceName,
		final String goalPlaceName,
		final double totalDistance,
		final String goalLatitude,
		final String goalLongitude,
		final boolean transactionFinished
	) {
		this.id = transactionId;
		this.stName = startPlaceName;
		this.glName = goalPlaceName;
		this.dist = totalDistance;
		this.glLat = goalLatitude;
		this.glLng = goalLongitude;
		this.finish = transactionFinished;
		this.locationInfos = Lists.newArrayList();
	}

	/**
	 * @param datetime 날짜 (yyyyMMddHHmmssS- 형식)
	 * @param lat 위도
	 * @param lng 경도
	 */
	public void addLocationInfo(
		final String datetime,
		final String lat,
		final String lng
	) {
		locationInfos.add(
			BizNaviLocationInfoDto.builder()
				.datetime(datetime)
				.lat(lat)
				.lng(lng)
				.build()
		);
	}

	public void addLocationInfo(BizNaviLocationInfoDto dto) {
		locationInfos.add(dto);
	}

	public Location getGoalLocation() {
		return new Location(glLat, glLng);
	}

	public Location getLastLocation() {
		final int lastIndex = locationInfos.size() - 1;
		return locationInfos.get(lastIndex).getLocation();
	}

	public String getLastDatetime() {
		final int lastIndex = locationInfos.size() - 1;
		return locationInfos.get(lastIndex).getDatetime();
	}
}

