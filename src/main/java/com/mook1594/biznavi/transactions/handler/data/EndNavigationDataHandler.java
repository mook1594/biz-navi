package com.mook1594.biznavi.transactions.handler.data;

import java.util.Optional;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.handler.valid.ValidHandlerResolver;

public class EndNavigationDataHandler implements NavigationDataHandler {

	@Override
	public boolean isType(NavigationDataType type) {
		return NavigationDataType.END_NAVI == type;
	}

	@Override
	public Optional<BizNaviTransactionDto> resolveNavigationData(NavigationData navigationData,
		Optional<BizNaviTransactionDto> dto) {
		if(dto.isPresent() && ValidHandlerResolver.handle(navigationData, dto.get())) {
			dto.get().addLocationInfo(
				navigationData.toBizNaviLocationInfoDto()
			);
			dto.get().setWorkAccept(true);
		}
		dto.get().setFinish(true);
		return dto;
	}
}
