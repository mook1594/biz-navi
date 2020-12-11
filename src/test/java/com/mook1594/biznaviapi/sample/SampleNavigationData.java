package com.mook1594.biznaviapi.sample;

import java.math.BigDecimal;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.command.NavigationLocationInfo;

public class SampleNavigationData {
	public static NavigationData getNavigationStartDate() {
		return new NavigationData(NavigationDataType.START_NAVI,
			new NavigationLocationInfo(
				"kakao20201113-0001",
				"202011131101020003",
				new BigDecimal(7000),
				"성남시청",
				"카카오모빌리티",
				new BigDecimal("127.567849497291"),
				new BigDecimal("36.957739187083654")
			));
	}

	public static NavigationData getNavigationUpdateDate() {
		return new NavigationData(NavigationDataType.UPDATE_LOCATION,
			new NavigationLocationInfo (
				"kakao20201113-0001",
				"202011131101020004",
				new BigDecimal(6400),
				new BigDecimal("127.567849497291"),
				new BigDecimal("36.957739187083654")
			));
	}

	public static NavigationData getNavigationEndDate() {
		return new NavigationData(NavigationDataType.END_NAVI,
			new NavigationLocationInfo (
				"kakao20201113-0001",
				"202011131101020005",
				new BigDecimal(20),
				new BigDecimal("37.394049927942085"),
				new BigDecimal("127.10985018378015")
			));
	}
}
