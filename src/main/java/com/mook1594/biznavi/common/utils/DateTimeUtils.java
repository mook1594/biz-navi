package com.mook1594.biznavi.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import com.google.common.base.Strings;

public class DateTimeUtils {

	private static final String DEFAULT_DATETIME_FORMAT = "yyyyMMddHHmmss";
	private static final int MILLI_SECOND_LENGTH = 3;
	private static final int MICRO_SECOND_LENGTH = 3;

	public static LocalDateTime toLocalDatetime(final String datetimeString) {
		int length = DEFAULT_DATETIME_FORMAT.length() + MILLI_SECOND_LENGTH + MICRO_SECOND_LENGTH;
		final String datetimeStringWithZeroPadding = Strings.padEnd(datetimeString, length, '0');
		return LocalDateTime.parse(datetimeStringWithZeroPadding, formatter());
	}

	public static String toString(final LocalDateTime datetime) {
		return datetime.format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT));
	}

	private static DateTimeFormatter formatter() {
		return new DateTimeFormatterBuilder()
			.appendPattern(DEFAULT_DATETIME_FORMAT)
			.appendValue(ChronoField.MILLI_OF_SECOND, MILLI_SECOND_LENGTH)
			.appendValue(ChronoField.MICRO_OF_SECOND, MICRO_SECOND_LENGTH)
			.toFormatter();
	}

	public static LocalDateTime now() {
		return LocalDateTime.now();
	}
}
