package com.mook1594.biznavi.transactions.handler.valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.mook1594.biznavi.common.enums.NavigationDataType;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public class ValidHandlerResolver {

	private static Map<NavigationDataType, List<ValidHandler>> handlerMap;

	static {
		handlerMap = new HashMap<>();
		handlerMap.put(NavigationDataType.START_NAVI, Lists.newArrayList());
		handlerMap.put(NavigationDataType.UPDATE_LOCATION, Lists.newArrayList(
			new ValidMoveHandler(),
			new ValidTimeHandler()
		));
		handlerMap.put(NavigationDataType.END_NAVI, Lists.newArrayList(
			new ValidGoalHandler()
		));
	}

	public static List<ValidHandler> getHandlers(final NavigationDataType type) {
		return handlerMap.get(type);
	}

	public static boolean handle(final NavigationData navigationData, final BizNaviTransactionDto transactionDto) {
		return getHandlers(navigationData.getType()).stream()
			.allMatch(h -> h.valid(navigationData, transactionDto));
	}
}
