package com.mook1594.biznaviapi.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mook1594.biznaviapi.component.Location;

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

	public static List<Location> fromKakaoMobilityToSeongNamCityHall() {
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
}
