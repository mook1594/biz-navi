package com.mook1594.biznavi.common.utils;

import java.math.BigDecimal;

public class DistanceUtils {
	public static final BigDecimal PI = BigDecimal.valueOf(Math.PI);
	public static final BigDecimal DEGREE_180 = BigDecimal.valueOf(180.0);
	public static final BigDecimal CONSTANT_60 = BigDecimal.valueOf(60);
	public static final BigDecimal CONSTANT_1_1515 = BigDecimal.valueOf(1.1515);
	public static final BigDecimal MILE_TO_CENTIMETER = BigDecimal.valueOf(1609344);
	public static final BigDecimal UNIT = BigDecimal.valueOf(1000);

	public static BigDecimal degreeToRadian(BigDecimal degree) {
		return degree.multiply(PI)
			.divide(DEGREE_180, 14, BigDecimal.ROUND_CEILING);
	}

	public static BigDecimal radianToDegree(BigDecimal radian) {
		return radian.multiply(DEGREE_180)
			.divide(PI, 14, BigDecimal.ROUND_CEILING);
	}


}
