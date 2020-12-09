package com.mook1594.biznavi.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.model.NavigationData;
import com.mook1594.biznavi.sample.SampleNavigationData;

@DisplayName("조건3. 1시간 동안 위치 정보 업데이트 되지 않음.")
public class BizNaviHandlerCondition3Test {

	@Test
	public void compareDatetime() {
		final NavigationData updateData = SampleNavigationData.getNavigationUpdateDate();
		LocalDateTime date = LocalDateTime.now();

		for(int i = 0; i< 10; i++) {
			String dt = date.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSS"));
			System.out.println(dt);
		}

	}
}
