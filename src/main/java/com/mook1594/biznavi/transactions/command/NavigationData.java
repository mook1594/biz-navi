package com.mook1594.biznavi.transactions.command;

import com.mook1594.biznavi.common.enums.NavigationDataType;

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
}
