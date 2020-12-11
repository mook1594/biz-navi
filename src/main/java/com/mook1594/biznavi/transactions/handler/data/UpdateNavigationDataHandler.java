package com.mook1594.biznavi.transactions.handler.data;

import java.util.Optional;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public class UpdateNavigationDataHandler implements NavigationDataHandler {

	@Override
	public boolean isType(NavigationDataType type) {
		return NavigationDataType.UPDATE_LOCATION == type;
	}

	@Override
	public Optional<BizNaviTransactionDto> resolveNavigationData(NavigationData navigationData,
		Optional<BizNaviTransactionDto> dto) {
		if(dto.isPresent()) {
			dto.get().addLocationInfo(
				navigationData.toBizNaviLocationInfoDto()
			);
			return dto;
		}
		return Optional.empty();
	}
}
