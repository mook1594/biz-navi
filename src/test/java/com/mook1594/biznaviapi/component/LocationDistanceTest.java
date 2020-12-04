package com.mook1594.biznaviapi.component;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * To test {@code LocationDistance}
 */
public class LocationDistanceTest {

	@ParameterizedTest
	@DisplayName("구글 위경도로 거리 계산이 같은지 확인")
	@CsvSource(delimiter = '/', value = {
		"37.39619370849921/127.1097258193312/37.39621614484436/127.11270243986814/262.98",
		"37.39623409391561/127.10968628167701/37.39383785488478/127.11276457046759/380.01"
	})
	public void distanceTest1(final String lat1, final String lng1, final String lat2, final String lng2, final double expected){
		Location location1 = new Location(lat1, lng1);
		Location location2 = new Location(lat2, lng2);

		LocationDistance locationDistance = new LocationDistance(location1, location2);
		BigDecimal distance = locationDistance.distanceForMeter();

		assertEquals(expected, distance);
	}

}
