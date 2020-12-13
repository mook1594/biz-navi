package com.mook1594.biznavi.sample;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.command.NavigationLocationInfo;

public class SampleNavigationData {
	public static NavigationData getNavigationStartData() {
		return new NavigationData(NavigationDataType.START_NAVI,
			NavigationLocationInfo.builder()
				.transId("kakao20201113-0001")
				.dateTime("202011131101020003")
				.totalDistance(7000)
				.startName("성남시청")
				.goalName("카카오모빌리티")
				.lat("36.957739187083654")
				.lng("127.567849497291")
				.build()
		);
	}

	public static NavigationData getNavigationUpdateData() {
		return new NavigationData(NavigationDataType.UPDATE_LOCATION,
			NavigationLocationInfo.builder()
				.transId("kakao20201113-0001")
				.dateTime("202011131101020004")
				.remainDistance(6400)
				.lat("36.957739187083654")
				.lng("127.567849497291")
				.build()
			);
	}

	public static NavigationData getNavigationEndData() {
		return new NavigationData(NavigationDataType.END_NAVI,
			NavigationLocationInfo.builder()
				.transId("kakao20201113-0001")
				.dateTime("202011131101020005")
				.remainDistance(20)
				.lat("37.394049927942085")
				.lng("127.10985018378015")
				.build()
		);
	}
}
