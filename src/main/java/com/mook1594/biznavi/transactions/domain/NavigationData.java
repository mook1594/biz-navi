package com.mook1594.biznavi.transactions.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.transactions.dto.LocationInfoDto;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NavigationData {

	private NavigationDataType type;
	private NavigationLocationInfo location;

	/**
	 * @param type 네이게이션 데이터 타입
	 * @param locationInformation 네이게이션 위치정보
	 */
	@Builder
	public NavigationData(
		final NavigationDataType type,
		final NavigationLocationInfo locationInformation
	) {
		this.type = type;
		this.location = locationInformation;
	}

	public TransactionDto toBizNaviTransactionDto(final Location goalLocation) {
		return TransactionDto.builder()
			.transactionId(location.getTransId())
			.startName(location.getStartName())
			.totalDistance(location.getTotalDistance().doubleValue())
			.goalName(location.getGoalName())
			.goalLat(goalLocation.getLatitude().toString())
			.goalLng(goalLocation.getLongitude().toString())
			.build();
	}

	public LocationInfoDto toBizNaviLocationInfoDto() {
		return LocationInfoDto.builder()
			.datetime(location.getDateTime())
			.remainDist(location.getRemainDistance().doubleValue())
			.lat(location.getLat().toString())
			.lng(location.getLng().toString())
			.build();
	}
}
