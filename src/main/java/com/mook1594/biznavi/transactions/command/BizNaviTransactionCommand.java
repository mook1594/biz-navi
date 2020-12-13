package com.mook1594.biznavi.transactions.command;

import com.mook1594.biznavi.common.enums.NavigationDataType;

import lombok.Data;

@Data
public class BizNaviTransactionCommand {

	private String type;

	private BizNaviLocationInfoCommand location;

	public NavigationData toNavigationData() {
		return NavigationData.builder()
			.type(NavigationDataType.resolveByTypeCode(type))
			.locationInformation(location.toLocationInfo())
			.build();
	}
}
