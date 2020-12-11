package com.mook1594.biznavi.transactions.handler.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public class NavigationDataHandlerResolver {

	private static List<NavigationDataHandler> handlers;

	static {
		handlers = new ArrayList<>();
		handlers.add(new StartNavigationDataHandler());
		handlers.add(new UpdateNavigationDataHandler());
		handlers.add(new EndNavigationDataHandler());
	}

	public static List<NavigationDataHandler> getHandlers() {
		return handlers;
	}

	public static Optional<BizNaviTransactionDto> handle(final NavigationData data, final Optional<BizNaviTransactionDto> transaction) {
		return NavigationDataHandlerResolver.getHandlers().stream()
			.filter(h -> h.isType(data.getType()))
			.map(h -> h.resolveNavigationData(data, transaction))
			.findFirst()
			.orElse(Optional.empty());
	}
}
