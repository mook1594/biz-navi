package com.mook1594.biznavi.sample;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.command.NavigationLocationInfo;

public class SampleNavigationData {
	public static NavigationData getNavigationStartDate() {
		return new NavigationData(NavigationDataType.START_NAVI,
			new NavigationLocationInfo(
				"kakao20201113-0001",
				"202011131101020003",
				7000,
				"성남시청",
				"카카오모빌리티",
				"36.957739187083654",
				"127.567849497291"
			));
	}

	public static NavigationData getNavigationUpdateDate() {
		return new NavigationData(NavigationDataType.UPDATE_LOCATION,
			new NavigationLocationInfo (
				"kakao20201113-0001",
				"202011131101020004",
				6400,
				"36.957739187083654",
				"127.567849497291"
			));
	}

	public static NavigationData getNavigationEndDate() {
		return new NavigationData(NavigationDataType.END_NAVI,
			new NavigationLocationInfo (
				"kakao20201113-0001",
				"202011131101020005",
				20,
				"37.394049927942085",
				"127.10985018378015"
			));
	}
}
