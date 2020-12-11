package com.mook1594.biznavi.transactions.command;

import java.util.Objects;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.common.model.Location;

public class NavigationData {

	private NavigationDataType type;
	private NavigationLocationInfo location;

	/**
	 * @param type 네이게이션 데이터 타입
	 * @param location 네이게이션 위치정보
	 */
	public NavigationData(
		final NavigationDataType type,
		final NavigationLocationInfo location
	) {
		this.type = type;
		this.location = location;
	}

	public Location getLocation() {
		if(Objects.nonNull(location)) {
			return location.getLocation();
		}
		return null;
	}
}
