package com.mook1594.biznavi.transactions.handler.valid;

import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.common.model.LocationDistance;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidMoveHandler implements ValidHandler {

	private static final int LIMIT_VALID_MOVE = 500;

	@Override
	public boolean valid(final NavigationData navigationData, final TransactionDto transactionDto) {
		final Location fromLocation = transactionDto.getLastLocation();
		final Location toLocation = navigationData.getLocation().getLocation();
		final LocationDistance distance = new LocationDistance(fromLocation, toLocation);

		final int moveDistance = distance.distanceForMeter().intValue();
		log.info("moveForMeter: {}", moveDistance);

		return moveDistance > LIMIT_VALID_MOVE;
	}
}
