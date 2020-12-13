package com.mook1594.biznavi.common.resolver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.sample.SampleLocation;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.domain.NavigationLocationInfo;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.handler.valid.ValidHandler;
import com.mook1594.biznavi.transactions.handler.valid.ValidMoveHandler;

@DisplayName("조건2. GPS의 이동거리가 500m 이내인 경우")
public class BizNaviHandlerCondition2Test {

	private ValidHandler validHandler;

	@BeforeEach
	public void init() {
		validHandler = new ValidMoveHandler();
	}

	@Test
	@DisplayName("GPS 이동거리가 500m 초과")
	public void moveDistance1() {
		final List<Location> routeLocations = SampleLocation.routeFromSeongNamCityHallToKakaoMobility();
		final Location arriveLocation = routeLocations.get(0);
		final Location goalLocation = routeLocations.get(3);

		final BizNaviTransactionDto transactionDto = getTransactionDtoWithLocation(goalLocation);
		final NavigationData navigationData = getNavigationDataWithLocation(arriveLocation);

		boolean result = validHandler.valid(navigationData, transactionDto);

		assertEquals(true, result);
	}

	@Test
	@DisplayName("GPS 이동거리가 500m 이내")
	public void moveDistance2() {
		final List<Location> routeLocations = SampleLocation.routeFromSeongNamCityHallToKakaoMobility();
		final Location arriveLocation = routeLocations.get(0);
		final Location goalLocation = routeLocations.get(1);

		final BizNaviTransactionDto transactionDto = getTransactionDtoWithLocation(goalLocation);
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

	private BizNaviTransactionDto getTransactionDtoWithLocation(final Location location) {
		final BizNaviTransactionDto bizNaviTransactionDto = BizNaviTransactionDto.builder()
			.build();
		bizNaviTransactionDto.addLocationInfo(
			"",
			location.getLatitude().toString(),
			location.getLongitude().toString());

		return bizNaviTransactionDto;
	}
}
