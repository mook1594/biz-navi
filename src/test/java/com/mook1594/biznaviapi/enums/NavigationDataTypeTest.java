package com.mook1594.biznaviapi.enums;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NavigationDataTypeTest {

	@Test
	@DisplayName("string to Enum 테스트 - START_NAVI")
	public void startType(){
		final String typeCode = "StartNavi";

		final NavigationDataType dataType = NavigationDataType.resolveByTypeCode(typeCode);

		assertEquals(dataType, NavigationDataType.START_NAVI);
	}

	@Test
	@DisplayName("string to Enum 테스트 - UPDATE_LOCATION")
	public void updateType(){
		final String typeCode = "UpdateLocation";

		final NavigationDataType dataType = NavigationDataType.resolveByTypeCode(typeCode);

		assertEquals(dataType, NavigationDataType.UPDATE_LOCATION);
	}

	@Test
	@DisplayName("string to Enum 테스트 - END_NAVI")
	public void endType(){
		final String typeCode = "Close";

		final NavigationDataType dataType = NavigationDataType.resolveByTypeCode(typeCode);

		assertEquals(dataType, NavigationDataType.END_NAVI);
	}

	@Test
	@DisplayName("string to Enum 테스트 - UNKNOWN")
	public void undefinedType(){
		final String typeCode = "NoType";

		final NavigationDataType dataType = NavigationDataType.resolveByTypeCode(typeCode);

		assertEquals(dataType, NavigationDataType.UNKNOWN);
	}
}
