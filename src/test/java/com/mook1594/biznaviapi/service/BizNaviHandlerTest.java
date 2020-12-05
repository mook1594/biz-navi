package com.mook1594.biznaviapi.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznaviapi.model.NavigationData;
import com.mook1594.biznaviapi.model.NavigationSampleData;

public class BizNaviHandlerTest {

	@Test
	@DisplayName("조건1. 설정 목적지와 네이 종료 위치가 100m 이내인지 확인")
	public void remainDistance100() {
		NavigationData arrive = NavigationSampleData.getNavigationEndDate();
		boolean result = BizNaviHandler.isArriveGoal(arrive);

		assertEquals(true, result);
	}
}
