package com.mook1594.biznavi.common.resolver;

import java.time.Duration;
import java.time.LocalDateTime;

import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.common.model.LocationDistance;
import com.mook1594.biznavi.common.utils.DateTimeUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BizNaviHandler {

	private static final int LIMIT_COMPLETE_DISTANCE = 100;
	private static final int LIMIT_VALID_MOVE = 500;
	private static final int LIMIT_VALID_TIME_HOUR = 1;

	private static final long SECOND_TO_HOUR = 3600;

	public static boolean isArriveGoal(final Location arriveLocation, final Location goalLocation) {
		LocationDistance distance = new LocationDistance(goalLocation, arriveLocation);

		final int remainDistance = distance.distanceForMeter().intValue();
		log.info("distanceForMeter: {}", remainDistance);
		return remainDistance <= LIMIT_COMPLETE_DISTANCE;
	}

	public static boolean isValidMove(Location fromLocation, Location toLocation) {
		LocationDistance distance = new LocationDistance(fromLocation, toLocation);

		final int moveDistance = distance.distanceForMeter().intValue();
		log.info("moveForMeter: {}", moveDistance);
		return moveDistance > LIMIT_VALID_MOVE;
	}

	public static boolean isValidTime(final String startDatetimeString, final String endDatetimeString) {
		LocalDateTime startDatetime = DateTimeUtils.toLocalDatetime(startDatetimeString);
		LocalDateTime endDatetime = DateTimeUtils.toLocalDatetime(endDatetimeString);

		Duration duration = Duration.between(startDatetime, endDatetime);
		double hour = duration.getSeconds() * 1.0 / SECOND_TO_HOUR;
		log.info("hour: {}, {}", hour, duration.getSeconds());
		return hour <= LIMIT_VALID_TIME_HOUR;
	}
}
