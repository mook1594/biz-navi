package com.mook1594.biznavi.transactions.handler.valid;

import java.time.Duration;
import java.time.LocalDateTime;

import com.mook1594.biznavi.common.utils.DateTimeUtils;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidTimeHandler implements ValidHandler {

	private static final int LIMIT_VALID_TIME_HOUR = 1;
	private static final long SECOND_TO_HOUR = 3600;

	@Override
	public boolean valid(final NavigationData navigationData, final BizNaviTransactionDto transactionDto) {
		final String fromDatetimeString = transactionDto.getLastDatetime();
		final String toDatetimeString = navigationData.getLocation().getDateTime();
		final LocalDateTime fromDatetime = DateTimeUtils.toLocalDatetime(fromDatetimeString);
		final LocalDateTime toDatetime = DateTimeUtils.toLocalDatetime(toDatetimeString);

		final Duration duration = Duration.between(fromDatetime, toDatetime);
		final double hour = duration.getSeconds() * 1.0 / SECOND_TO_HOUR;
		log.info("hour: {}, {}", hour, duration.getSeconds());

		return hour <= LIMIT_VALID_TIME_HOUR && 0 <= hour;
	}
}
