package com.mook1594.biznavi.transactions.handler;

import java.util.Optional;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public interface NavigationDataHandler {

	boolean isType(final NavigationDataType type);

	Optional<BizNaviTransactionDto> resolveNavigationData(
		final NavigationData navigationData, final Optional<BizNaviTransactionDto> dto);
}
