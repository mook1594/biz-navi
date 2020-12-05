package com.mook1594.biznavi.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {

	public static BigDecimal sin(BigDecimal value) {
		return BigDecimal.valueOf(
			Math.sin(value.doubleValue())
		);
	}

	public static BigDecimal cos(BigDecimal value) {
		return BigDecimal.valueOf(
			Math.cos(value.doubleValue())
		);
	}

	public static BigDecimal acos(BigDecimal value) {
		return BigDecimal.valueOf(
			Math.acos(value.doubleValue())
		);
	}
}
