package com.mook1594.biznavi.transactions.handler.valid;

import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.common.model.LocationDistance;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidGoalHandler implements ValidHandler {

	private static final int LIMIT_COMPLETE_DISTANCE = 100;

	@Override
	public boolean valid(final NavigationData navigationData, final BizNaviTransactionDto transactionDto) {
		final Location goalLocation = transactionDto.getGoalLocation();
		final Location arriveLocation = navigationData.getLocation().getLocation();
		final LocationDistance distance = new LocationDistance(goalLocation, arriveLocation);

		final int remainDistance = distance.distanceForMeter().intValue();
		log.info("distanceForMeter: {}", remainDistance);

		return remainDistance <= LIMIT_COMPLETE_DISTANCE;
	}
}
