package com.mook1594.biznavi.common.resolver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.sample.SampleLocation;
import com.mook1594.biznavi.sample.SampleNavigationData;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.command.NavigationLocationInfo;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
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
		NavigationData arrive = SampleNavigationData.getNavigationEndDate();
		Location arriveLocation = arrive.getLocationInfo().getLocation();
		Location goalLocation = SampleLocation.kakaoMobility();

		final BizNaviTransactionDto transactionDto = getTransactionDtoWithLocation(goalLocation);
		final NavigationData navigationData = getNavigationDataWithLocation(arriveLocation);

		boolean result = validHandler.valid(navigationData, transactionDto);

		assertEquals(true, result);
	}

	@Test
	@DisplayName("설정 목적지와 네비 종료 위치가 100m 초과 확인")
	public void remainDistance2() {
		Location arriveLocation = SampleLocation.yatapStation();
		Location goalLocation = SampleLocation.kakaoMobility();

		final BizNaviTransactionDto transactionDto = getTransactionDtoWithLocation(goalLocation);
		final NavigationData navigationData = getNavigationDataWithLocation(arriveLocation);

		boolean result = validHandler.valid(navigationData, transactionDto);

		assertEquals(false, result);
	}

	private NavigationData getNavigationDataWithLocation(final Location location) {
		return new NavigationData(
			NavigationDataType.START_NAVI,
			new NavigationLocationInfo(
				"navi-1",
				"",
				0,
				"",
				"",
				location.getLatitude().toString(),
				location.getLongitude().toString())
		);
	}

	private BizNaviTransactionDto getTransactionDtoWithLocation(final Location location) {
		final BizNaviTransactionDto bizNaviTransactionDto = BizNaviTransactionDto.builder()
			.goalLatitude(location.getLatitude().toString())
			.goalLongitude(location.getLongitude().toString())
			.build();
		return bizNaviTransactionDto;
	}
}
