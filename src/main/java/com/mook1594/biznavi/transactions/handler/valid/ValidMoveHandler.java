package com.mook1594.biznavi.transactions.handler.valid;

import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.common.model.LocationDistance;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public class ValidMoveHandler implements ValidHandler {

	private static final int LIMIT_VALID_MOVE = 500;

	@Override
	public boolean valid(final NavigationData navigationData, final BizNaviTransactionDto transactionDto) {
		final Location fromLocation = transactionDto.getLocationInfos().get(0).getLocation();
		final Location toLocation = navigationData.getLocationInfo().getLocation();
		final LocationDistance distance = new LocationDistance(fromLocation, toLocation);

		final int moveDistance = distance.distanceForMeter().intValue();
		return moveDistance > LIMIT_VALID_MOVE;
	}
}
