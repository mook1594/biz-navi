package com.mook1594.biznavi.transactions.handler.data;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

public class NavigationDataHandlerResolver {

	private static List<NavigationDataHandler> handlers;

	static {
		handlers = Lists.newArrayList(
			new StartNavigationDataHandler(),
			new UpdateNavigationDataHandler(),
			new EndNavigationDataHandler()
		);
	}

	public static List<NavigationDataHandler> getHandlers() {
		return handlers;
	}

	public static Optional<TransactionDto> handle(final NavigationData data, final Optional<TransactionDto> transaction) {
		return handlers.stream()
			.filter(h -> h.isType(data.getType()))
			.map(h -> h.resolveNavigationData(data, transaction))
			.filter(t -> t.isPresent())
			.findFirst()
			.orElse(Optional.empty());
	}
}
