package com.mook1594.biznavi.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("조건3. 1시간 동안 위치 정보 업데이트 되지 않음.")
public class BizNaviHandlerCondition3Test {

	@ParameterizedTest
	@DisplayName("시간차이 확인")
	@CsvSource(delimiter = ',', value = {
		"202011131101020001,202011131201520002, false",
		"202012010402500002,202012010412500002, true"
	})
	public void timespan(final String datetimeString1, final String datetimeString2, final boolean expected) {
		boolean result = BizNaviHandler.isValidTime(datetimeString1, datetimeString2);

		assertEquals(expected, result);
	}
}
