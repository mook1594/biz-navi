package com.mook1594.biznavi.transactions.handler.data;

import java.util.Optional;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.common.model.Location;
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
		final Location goalLocation = getGoalLocationInfo();
		final TransactionDto transaction = navigationData.toBizNaviTransactionDto(goalLocation);
		transaction.addLocationInfo(
			navigationData.toBizNaviLocationInfoDto()
		);
		return Optional.ofNullable(transaction);
	}

	//TODO: 가정: 어딘가에서 도착지에 대한 GPS 위치 정보를 조회한다.
	private Location getGoalLocationInfo() {
		//카카오모빌리티 위도, 경도
		return new Location("37.39422978891167", "127.1101377782004");
	}
}
