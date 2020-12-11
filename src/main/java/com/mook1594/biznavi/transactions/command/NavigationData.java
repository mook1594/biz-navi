package com.mook1594.biznavi.transactions.command;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.dto.BizNaviLocationInfoDto;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

import lombok.Getter;

@Getter
public class NavigationData {
	private NavigationDataType type;
	private NavigationLocationInfo locationInfo;

	/**
	 * @param type 네이게이션 데이터 타입
	 * @param locationInformation 네이게이션 위치정보
	 */
	public NavigationData(
		final NavigationDataType type,
		final NavigationLocationInfo locationInformation
	) {
		this.type = type;
		this.locationInfo = locationInformation;
	}

	public BizNaviTransactionDto toBizNaviTransactionDto() {
		return BizNaviTransactionDto.builder()
			.transactionId(locationInfo.getTransId())
			.startPlaceName(locationInfo.getStartName())
			.totalDistance(locationInfo.getTotalDistance().doubleValue())
			.goalPlaceName(locationInfo.getGoalName())
			.transactionFinished(false)
			.build();
	}

	public BizNaviLocationInfoDto toBizNaviLocationInfoDto() {
		return BizNaviLocationInfoDto.builder()
			.datetime(locationInfo.getDateTime())
			.lat(locationInfo.getLat().toString())
			.lng(locationInfo.getLng().toString())
			.build();
	}
}
