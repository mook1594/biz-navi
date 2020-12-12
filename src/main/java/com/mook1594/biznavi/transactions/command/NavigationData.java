package com.mook1594.biznavi.transactions.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.dto.BizNaviLocationInfoDto;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

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

	public BizNaviTransactionDto toBizNaviTransactionDto() {
		return BizNaviTransactionDto.builder()
			.transactionId(location.getTransId())
			.startPlaceName(location.getStartName())
			.totalDistance(location.getTotalDistance().doubleValue())
			.goalPlaceName(location.getGoalName())
			.goalLatitude(location.getLat().toString())
			.goalLongitude(location.getLng().toString())
			.transactionFinished(false)
			.build();
	}

	public BizNaviLocationInfoDto toBizNaviLocationInfoDto() {
		return BizNaviLocationInfoDto.builder()
			.datetime(location.getDateTime())
			.remainDist(location.getRemainDistance().doubleValue())
			.lat(location.getLat().toString())
			.lng(location.getLng().toString())
			.build();
	}
}
