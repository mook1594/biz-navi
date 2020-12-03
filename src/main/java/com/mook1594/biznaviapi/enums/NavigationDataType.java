package com.mook1594.biznaviapi.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;

import com.google.common.collect.ImmutableMap;

import lombok.Getter;

public enum NavigationDataType {
	START_NAVI("StartNavi"),
	UPDATE_LOCATION("UpdateLocation"),
	END_NAVI("Close"),
	UNKNOWN(Strings.EMPTY);

	private static final ImmutableMap<String, NavigationDataType> BY_TYPE_CODE = ImmutableMap
		.copyOf(Arrays.asList(NavigationDataType.values()).stream()
			.collect(Collectors.toMap(
				NavigationDataType::getCode, type -> type)));

	@Getter
	private final String code;

	NavigationDataType(final String code) {
		this.code = code;
	}

	public static final NavigationDataType resolveByTypeCode(final String code) {
		return BY_TYPE_CODE.containsKey(code) ? BY_TYPE_CODE.get(code) : UNKNOWN;
	}
}
