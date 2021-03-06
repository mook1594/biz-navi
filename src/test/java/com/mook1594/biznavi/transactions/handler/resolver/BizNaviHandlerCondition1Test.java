package com.mook1594.biznavi.transactions.handler.resolver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.sample.SampleLocation;
import com.mook1594.biznavi.sample.SampleNavigationData;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.domain.NavigationLocationInfo;
import com.mook1594.biznavi.transactions.dto.TransactionDto;
import com.mook1594.biznavi.transactions.handler.valid.ValidGoalHandler;
import com.mook1594.biznavi.transactions.handler.valid.ValidHandler;

@DisplayName("조건1. 내비 시작시 설정된 목적지와 내비의 종료 위치가 100m 이내인 경우")
public class BizNaviHandlerCondition1Test {

	private ValidHandler validHandler;

	@BeforeEach
	public void init() {
		validHandler = new ValidGoalHandler();
	}

	@Test
	@DisplayName("설정 목적지와 네비 종료 위치가 100m 이내인지 확인")
	public void remainDistance1() {
		NavigationData arrive = SampleNavigationData.getNavigationEndData();
		Location arriveLocation = arrive.getLocation().getLocation();
		Location goalLocation = SampleLocation.kakaoMobility();

		final TransactionDto transactionDto = getTransactionDtoWithLocation(goalLocation);
		final NavigationData navigationData = getNavigationDataWithLocation(arriveLocation);

		boolean result = validHandler.valid(navigationData, transactionDto);

		assertEquals(true, result);
	}

	@Test
	@DisplayName("설정 목적지와 네비 종료 위치가 100m 초과 확인")
	public void remainDistance2() {
		Location arriveLocation = SampleLocation.yatapStation();
		Location goalLocation = SampleLocation.kakaoMobility();

		final TransactionDto transactionDto = getTransactionDtoWithLocation(goalLocation);
		final NavigationData navigationData = getNavigationDataWithLocation(arriveLocation);

		boolean result = validHandler.valid(navigationData, transactionDto);

		assertEquals(false, result);
	}

	private NavigationData getNavigationDataWithLocation(final Location location) {
		return new NavigationData(
			NavigationDataType.START_NAVI,
			NavigationLocationInfo.builder()
				.transId("navi-1")
				.lat(location.getLatitude().toString())
				.lng(location.getLongitude().toString())
				.build()
		);
	}

	private TransactionDto getTransactionDtoWithLocation(final Location location) {
		final TransactionDto bizNaviTransactionDto = TransactionDto.builder()
			.goalLat(location.getLatitude().toString())
			.goalLng(location.getLongitude().toString())
			.build();
		return bizNaviTransactionDto;
	}
}
