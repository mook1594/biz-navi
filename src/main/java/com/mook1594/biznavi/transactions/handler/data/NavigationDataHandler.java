package com.mook1594.biznavi.transactions.handler.data;

import java.util.Optional;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

public interface NavigationDataHandler {

	boolean isType(final NavigationDataType type);

	Optional<TransactionDto> resolveNavigationData(
		final NavigationData navigationData, final Optional<TransactionDto> dto);
}
