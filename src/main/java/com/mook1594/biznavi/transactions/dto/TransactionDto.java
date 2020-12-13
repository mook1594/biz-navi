package com.mook1594.biznavi.transactions.dto;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.Lists;
import com.mook1594.biznavi.common.dto.AbstractCommonDto;
import com.mook1594.biznavi.common.model.Location;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "transaction")
@Getter
@JsonDeserialize(builder = TransactionDto.TransactionDtoBuilder.class)
public class TransactionDto extends AbstractCommonDto {

	@Id
	private final String transactionId;
	private final String startName;
	private final String goalName;
	private final double totalDistance;
	private final String goalLat;
	private final String goalLng;

	@Setter
	private boolean finish;

	@Setter
	private boolean workAccept;

	private final List<LocationInfoDto> locationInfos;

	/**
	 * @param transactionId 트렌젝션 ID
	 * @param startName 출발지명
	 * @param goalName 목표지명
	 * @param totalDistance 총 이동거리
	 * @param goalLat 목표지점 위도
	 * @param goalLng 목표지점 경도
	 * @param finish 완료여부
	 * @param workAccept 업무인정 여부
	 * @param locationInfos 이동 경로 정보
	 */
	@Builder
	public TransactionDto(
		final String transactionId,
		final String startName,
		final String goalName,
		final double totalDistance,
		final String goalLat,
		final String goalLng,
		final boolean finish,
		final boolean workAccept,
		final List<LocationInfoDto> locationInfos
	) {
		super();
		this.transactionId = transactionId;
		this.startName = startName;
		this.goalName = goalName;
		this.totalDistance = totalDistance;
		this.goalLat = goalLat;
		this.goalLng = goalLng;
		this.finish = finish;
		this.workAccept = workAccept;
		this.locationInfos = Objects.nonNull(locationInfos) ? locationInfos : Lists.newArrayList();
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
			LocationInfoDto.builder()
				.datetime(datetime)
				.lat(lat)
				.lng(lng)
				.build()
		);
	}

	public void addLocationInfo(LocationInfoDto dto) {
		locationInfos.add(dto);
	}

	@Transient
	@JsonIgnore
	public Location getGoalLocation() {
		return new Location(goalLat, goalLng);
	}

	@Transient
	@JsonIgnore
	public Location getLastLocation() {
		final int lastIndex = locationInfos.size() - 1;
		return locationInfos.get(lastIndex).getLocation();
	}

	@Transient
	@JsonIgnore
	public String getLastDatetime() {
		final int lastIndex = locationInfos.size() - 1;
		return locationInfos.get(lastIndex).getDatetime();
	}
}

