package com.mook1594.biznaviapi.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznaviapi.component.Location;
import com.mook1594.biznaviapi.model.NavigationData;
import com.mook1594.biznaviapi.sample.SampleLocation;
import com.mook1594.biznaviapi.sample.SampleNavigationData;

public class BizNaviHandlerTest {

	@Test
	@DisplayName("조건1. 설정 목적지와 네이 종료 위치가 100m 이내인지 확인")
	public void remainDistance1() {
		NavigationData arrive = SampleNavigationData.getNavigationEndDate();
		Location arriveLocation = arrive.getLocation();
		Location goalLocation = SampleLocation.kakaoMobility();
		boolean result = BizNaviHandler.isArriveGoal(arriveLocation, goalLocation);

		assertEquals(true, result);
	}

	@Test
	@DisplayName("조건1. 설정 목적지와 네이 종료 위치가 100m 초과 확인")
	public void remainDistance2() {
		Location arriveLocation = SampleLocation.yatapStation();
		Location goalLocation = SampleLocation.kakaoMobility();
		boolean result = BizNaviHandler.isArriveGoal(arriveLocation, goalLocation);

		assertEquals(false, result);
	}
}
