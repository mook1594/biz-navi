package com.mook1594.biznaviapi.service;

import com.mook1594.biznaviapi.component.Location;
import com.mook1594.biznaviapi.component.LocationDistance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BizNaviHandler {

	public static boolean isArriveGoal(final Location arriveLocation, final Location goalLocation) {
		LocationDistance distance = new LocationDistance(goalLocation, arriveLocation);

		final int remainDistance = distance.distanceForMeter().intValue();
		log.info("distanceFormeter: {}", remainDistance);
		return remainDistance <= 100;
	}
}
