package com.mook1594.biznavi.transactions.command;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.domain.NavigationData;

import lombok.Data;

@Data
public class TransactionCommand {

	private String type;

	private LocationInfoCommand location;

	public NavigationData toNavigationData() {
		return NavigationData.builder()
			.type(NavigationDataType.resolveByTypeCode(type))
			.locationInformation(location.toLocationInfo())
			.build();
	}
}
