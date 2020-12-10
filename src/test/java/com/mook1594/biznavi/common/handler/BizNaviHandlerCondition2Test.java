package com.mook1594.biznavi.common.handler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.sample.SampleLocation;

@DisplayName("조건2. GPS의 이동거리가 500m 이내인 경우")
public class BizNaviHandlerCondition2Test {

	@Test
	@DisplayName("GPS 이동거리가 500m 초과")
	public void moveDistance1() {
		List<Location> routeLocations = SampleLocation.routeFromKakaoMobilityToSeongNamCityHall();
		Location arriveLocation = routeLocations.get(0);
		Location goalLocation = routeLocations.get(3);
		boolean result = BizNaviHandler.isValidMove(arriveLocation, goalLocation);

		assertEquals(true, result);
	}

	@Test
	@DisplayName("GPS 이동거리가 500m 이내")
	public void moveDistance2() {
		List<Location> routeLocations = SampleLocation.routeFromKakaoMobilityToSeongNamCityHall();
		Location arriveLocation = routeLocations.get(0);
		Location goalLocation = routeLocations.get(1);
		boolean result = BizNaviHandler.isValidMove(arriveLocation, goalLocation);

		assertEquals(false, result);
	}
}
