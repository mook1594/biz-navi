package com.mook1594.biznaviapi.component;

import java.math.BigDecimal;

import com.mook1594.biznaviapi.utils.BigDecimalUtils;
import com.mook1594.biznaviapi.utils.DistanceUtils;

public class LocationDistance {


	private final Location fromLocation;
	private final Location toLocation;

	public LocationDistance(final Location fromLocation, final Location toLocation) {
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}

	public BigDecimal distanceForMile() {
		return DistanceUtils.radianToDegree(
			BigDecimalUtils.acos(calculateDistance())
		).multiply(DistanceUtils.CONSTANT_60)
			.multiply(DistanceUtils.CONSTANT_1_1515);
	}

	public BigDecimal distanceForMeter() {
		return distanceForMile()
				.multiply(DistanceUtils.MILE_TO_CENTIMETER)
				.divide(DistanceUtils.UNIT);
	}

	public BigDecimal distanceForKilometer() {
		return distanceForMeter()
				.divide(DistanceUtils.UNIT);
	}

	private BigDecimal theta(){
		return fromLocation.getLongitude()
			.subtract(toLocation.getLongitude());
	}

	private BigDecimal calculateDistance() {
		return sinAfterDegreeToRadian(fromLocation.getLatitude())
			.multiply(sinAfterDegreeToRadian(toLocation.getLatitude()))
			.add(
				cosAfterDegreeToRadian(fromLocation.getLatitude())
					.multiply(cosAfterDegreeToRadian(toLocation.getLatitude()))
					.multiply(cosAfterDegreeToRadian(theta()))
			);
	}

	private BigDecimal sinAfterDegreeToRadian(BigDecimal value) {
		return BigDecimalUtils.sin(
			DistanceUtils.degreeToRadian(value)
		);
	}

	private BigDecimal cosAfterDegreeToRadian(BigDecimal value) {
		return BigDecimalUtils.cos(
			DistanceUtils.degreeToRadian(value)
		);
	}
}
