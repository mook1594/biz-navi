package com.mook1594.biznavi.transactions.handler;

import java.util.Optional;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public class EndNavigationDataHandler implements NavigationDataHandler {
	@Override
	public boolean isType(NavigationDataType type) {
		return NavigationDataType.END_NAVI == type;
	}

	@Override
	public Optional<BizNaviTransactionDto> resolveNavigationData(NavigationData navigationData,
		Optional<BizNaviTransactionDto> dto) {
		if(dto.isPresent()) {
			dto.get().addLocationInfo(
				navigationData.getLocationInfo().getDateTime(),
				navigationData.getLocationInfo().getLat().toString(),
				navigationData.getLocationInfo().getLng().toString()
			);
			return dto;
		}
		return Optional.empty();
	}
}
