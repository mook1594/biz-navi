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
		"37.498495068571756/127.04468058121776/37.496738191793845/127.04550122065818/207.89",
		"37.497856434640305/127.02759024524354/37.500614608334786/127.03643968605313/840.35",
		"37.497878480784976/127.0275582021486/37.50427296938526/127.04823110389736/1960"
	})

	public void distanceTest1(final String lat1, final String lng1, final String lat2, final String lng2, final double expected){
		Location location1 = new Location(lat1, lng1);
		Location location2 = new Location(lat2, lng2);

		LocationDistance locationDistance = new LocationDistance(location1, location2);
		BigDecimal distance = locationDistance.distanceForMeter();

		assertEquals(expected, distance.doubleValue(), 5d); // 오차 5m
	}

}
