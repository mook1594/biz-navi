package com.mook1594.biznavi.common.resolver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.command.NavigationLocationInfo;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.handler.valid.ValidTimeHandler;

@DisplayName("조건3. 1시간 동안 위치 정보 업데이트 되지 않음.")
public class BizNaviHandlerCondition3Test {

	private ValidTimeHandler validHandler;

	@BeforeEach
	public void init() {
		validHandler = new ValidTimeHandler();
	}

	@ParameterizedTest
	@DisplayName("시간차이 확인")
	@CsvSource(delimiter = ',', value = {
		"202011131101020001,202011131201520002, false",
		"202012010402500002,202012010412500002, true"
	})
	public void timespan(final String datetimeString1, final String datetimeString2, final boolean expected) {
		final BizNaviTransactionDto transactionDto = getTransactionDtoWithDatetime(datetimeString1);
		final NavigationData navigationData = getNavigationDataWithDatetime(datetimeString2);

		boolean result = validHandler.valid(navigationData, transactionDto);

		assertEquals(expected, result);
	}

	private NavigationData getNavigationDataWithDatetime(final String datetime) {
		return new NavigationData(
			NavigationDataType.START_NAVI,
			new NavigationLocationInfo("navi-1", datetime, 0, "", "", "0", "0")
		);
	}

	private BizNaviTransactionDto getTransactionDtoWithDatetime(final String datetime) {
		final BizNaviTransactionDto bizNaviTransactionDto = BizNaviTransactionDto.builder()
			.build();
		bizNaviTransactionDto.addLocationInfo(datetime, "1", "1");

		return bizNaviTransactionDto;
	}
}
