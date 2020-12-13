package com.mook1594.biznavi.transactions.handler.data;

import java.util.Optional;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;
import com.mook1594.biznavi.transactions.handler.valid.ValidHandlerResolver;

public class StartNavigationDataHandler implements NavigationDataHandler {

	@Override
	public boolean isType(final NavigationDataType type) {
		return NavigationDataType.START_NAVI == type;
	}

	@Override
	public Optional<TransactionDto> resolveNavigationData(final NavigationData navigationData,
		final Optional<TransactionDto> dto) {

		if(ValidHandlerResolver.handle(navigationData, dto.orElse(null))) {
			return createBizNaviTransaction(navigationData);
		}
		return Optional.empty();
	}

	private Optional<TransactionDto> createBizNaviTransaction(final NavigationData navigationData) {
		final TransactionDto transaction = navigationData.toBizNaviTransactionDto();
		transaction.addLocationInfo(
			navigationData.toBizNaviLocationInfoDto()
		);
		return Optional.ofNullable(transaction);
	}
}
