package com.mook1594.biznavi.transactions.handler.valid;

import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.common.model.LocationDistance;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public class ValidGoalHandler implements ValidHandler {

	private static final int LIMIT_COMPLETE_DISTANCE = 100;

	@Override
	public boolean valid(final NavigationData navigationData, final BizNaviTransactionDto transactionDto) {
		final Location goalLocation = transactionDto.getGoalLocation();
		final Location arriveLocation = navigationData.getLocationInfo().getLocation();
		final LocationDistance distance = new LocationDistance(goalLocation, arriveLocation);

		final int remainDistance = distance.distanceForMeter().intValue();
		return remainDistance <= LIMIT_COMPLETE_DISTANCE;
	}
}
