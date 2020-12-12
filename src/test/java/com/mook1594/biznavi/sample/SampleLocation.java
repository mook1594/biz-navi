package com.mook1594.biznavi.sample;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.common.model.Location;
import com.mook1594.biznavi.common.model.LocationDistance;
import com.mook1594.biznavi.common.utils.DateTimeUtils;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.command.NavigationLocationInfo;

public class SampleLocation {

	public static Location kakaoMobility() {
		return new Location("37.39422978891167", "127.1101377782004");
	}

	public static Location seongnamCityHall() {
		return new Location("37.420043071340764", "127.12664628259833");
	}

	public static Location imaeStation() {
		return new Location("37.395561228161", "127.12818885960685");
	}

	public static Location yatapStation() {
		return new Location("37.411221411795914", "127.1286836182838");
	}

	public static Location pangyoStation() {
		return new Location("37.393974404327736", "127.11120819324809");
	}

	public static List<Location> routeFromSeongNamCityHallToKakaoMobility() {
		return new ArrayList<>(Arrays.asList(
			seongnamCityHall(),
			new Location("37.41878581136313", "127.12568038662694"),
			new Location("37.41875130216352", "127.12868572452132"),
			new Location("37.41567197130633", "127.12872134191839"),
			new Location("37.413909155146264", "127.12870491719819"),
			yatapStation(),
			new Location("37.4054297901921", "127.12847964268734"),
			new Location("37.40199512287283", "127.1283079366306"),
			new Location("37.399168773122625", "127.12858568041302"),
			imaeStation(),
			new Location("37.39073400488721", "127.12616607134565"),
			new Location("37.392312865485", "127.12446236597177"),
			new Location("37.3901225990193", "127.12237103139118"),
			new Location("37.39189208035783", "127.11678961233281"),
			new Location("37.39380177857995", "127.11306866622253"),
			pangyoStation(),
			kakaoMobility()
		));
	}

	public static List<NavigationData> navigationFromSeongNamCityHallToKakaoMobility() {
		final List<NavigationData> list = Lists.newArrayList();

		final String transactionId = "navi-0001";
		final LocalDateTime datetime = LocalDateTime.now();

		list.add(
			getNaviStartDataWithIdAndDatetime(transactionId, datetime)
		);

		List<Location> locationList = routeFromSeongNamCityHallToKakaoMobility();
		for(int i = 1; i < locationList.size() - 1; i++) {
			list.add(
				getNaviUpdateDataWithIdAndDatetimeAndLocation(transactionId,
					datetime.plusSeconds(i), locationList.get(i))
			);
		}

		list.add(
			getNaviEndDataWithIdAndDatetimeAndLocation(transactionId,
				datetime.plusSeconds(locationList.size()), locationList.get(locationList.size() - 1))
		);

		// System.out.println(getJson(list));
		return list;
	}

	private static String getJson(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception ex) {
			return "";
		}
	}

	private static NavigationData getNaviStartDataWithIdAndDatetime(final String id, final LocalDateTime datetime) {
		return NavigationData.builder()
			.type(NavigationDataType.START_NAVI)
			.locationInformation(new NavigationLocationInfo(
				id,
				DateTimeUtils.toString(datetime),
				new LocationDistance(seongnamCityHall(), kakaoMobility()).distanceForMeter().intValue(),
				"성남시청",
				"카카오모빌리티",
				kakaoMobility().getLatitude().toString(),
				kakaoMobility().getLongitude().toString()
			)).build();
	}

	private static NavigationData getNaviUpdateDataWithIdAndDatetimeAndLocation(
		final String id,
		final LocalDateTime dateTime,
		final Location location
	) {
		return NavigationData.builder()
			.type(NavigationDataType.UPDATE_LOCATION)
			.locationInformation(new NavigationLocationInfo(
				id,
				DateTimeUtils.toString(dateTime),
				new LocationDistance(location, kakaoMobility()).distanceForMeter().intValue(),
				location.getLatitude().toString(),
				location.getLongitude().toString()
			)).build();
	}

	private static NavigationData getNaviEndDataWithIdAndDatetimeAndLocation(
		final String id,
		final LocalDateTime dateTime,
		final Location location
	) {
		return NavigationData.builder()
			.type(NavigationDataType.END_NAVI)
			.locationInformation(new NavigationLocationInfo(
				id,
				DateTimeUtils.toString(dateTime),
				new LocationDistance(location, kakaoMobility()).distanceForMeter().intValue(),
				location.getLatitude().toString(),
				location.getLongitude().toString()
			)).build();
	}
}
