package com.mook1594.biznavi.transactions.command;

import com.mook1594.biznavi.transactions.domain.NavigationLocationInfo;

import lombok.Data;

@Data
public class BizNaviLocationInfoCommand {

	private String transId;
	private String dateTime;
	private int totalDistance;
	private int remainDistance;
	private String startName;
	private String goalName;
	private String lat;
	private String lng;

	public NavigationLocationInfo toLocationInfo() {
		return NavigationLocationInfo.builder()
			.transId(transId)
			.dateTime(dateTime)
			.totalDistance(totalDistance)
			.remainDistance(remainDistance)
			.startName(startName)
			.goalName(goalName)
			.lat(lat)
			.lng(lng)
			.build();
	}
}
