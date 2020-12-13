package com.mook1594.biznavi.transactions.handler.valid;

import java.time.Duration;
import java.time.LocalDateTime;

import com.mook1594.biznavi.common.utils.DateTimeUtils;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidTimeHandler implements ValidHandler {

	private static final int LIMIT_VALID_TIME_SECOND = 3600;

	@Override
	public boolean valid(final NavigationData navigationData, final TransactionDto transactionDto) {
		final String fromDatetimeString = transactionDto.getLastDatetime();
		final String toDatetimeString = navigationData.getLocation().getDateTime();
		final LocalDateTime fromDatetime = DateTimeUtils.toLocalDatetime(fromDatetimeString);
		final LocalDateTime toDatetime = DateTimeUtils.toLocalDatetime(toDatetimeString);

		final Duration duration = Duration.between(fromDatetime, toDatetime);
		final long seconds = duration.getSeconds();
		log.info("hour: {}, {}", seconds, duration.getSeconds());

		return seconds <= LIMIT_VALID_TIME_SECOND && 0 < seconds;
	}
}
