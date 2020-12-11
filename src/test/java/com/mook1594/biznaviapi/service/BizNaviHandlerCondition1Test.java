package com.mook1594.biznaviapi.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.common.resolver.BizNaviHandler;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznaviapi.sample.SampleLocation;
import com.mook1594.biznaviapi.sample.SampleNavigationData;

@DisplayName("조건1. 내비 시작시 설정된 목적지와 내비의 종료 위치가 100m 이내인 경우")
public class BizNaviHandlerCondition1Test {

	@Test
	@DisplayName("설정 목적지와 네비 종료 위치가 100m 이내인지 확인")
	public void remainDistance1() {
		NavigationData arrive = SampleNavigationData.getNavigationEndDate();
		Location arriveLocation = arrive.getLocation();
		Location goalLocation = SampleLocation.kakaoMobility();
		boolean result = BizNaviHandler.isArriveGoal(arriveLocation, goalLocation);

		assertEquals(true, result);
	}

	@Test
	@DisplayName("설정 목적지와 네비 종료 위치가 100m 초과 확인")
	public void remainDistance2() {
		Location arriveLocation = SampleLocation.yatapStation();
		Location goalLocation = SampleLocation.kakaoMobility();
		boolean result = BizNaviHandler.isArriveGoal(arriveLocation, goalLocation);

		assertEquals(false, result);
	}
}
