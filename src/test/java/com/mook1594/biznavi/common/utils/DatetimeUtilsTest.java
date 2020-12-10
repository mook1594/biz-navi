package com.mook1594.biznavi.common.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DatetimeUtilsTest {

	private final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSS";

	@ParameterizedTest
	@DisplayName("string을 LocalDatetime으로 변환")
	@CsvSource(delimiter = ',', value = {
		"202011131101020001,2020-11-13 11:01:02.0001",
		"202012010402500002,2020-12-01 04:02:50.0002"
	})
	public void toLocalDatetime(final String datetimeString, final String expected) {
		final String string1 = datetimeString;
		LocalDateTime localDateTime = DatetimeUtils.toLocalDatetime(string1);
		assertEquals(expected, localDateTime.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT)));
	}

	@ParameterizedTest
	@DisplayName("시간차이 확인")
	@CsvSource(delimiter = ',', value = {
		"202011131101020001,202011131201020002, 1",
		"202012010402500002,202012011002500002, 6"
	})
	public void timespan(final String datetimeString1, final String datetimeString2, final int hour) {
		LocalDateTime localDateTime1 = DatetimeUtils.toLocalDatetime(datetimeString1);
		LocalDateTime localDateTime2 = DatetimeUtils.toLocalDatetime(datetimeString2);

		Duration duration = Duration.between(localDateTime1, localDateTime2);

		assertEquals(hour, duration.getSeconds() / 3600);
	}
}
