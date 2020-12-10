package com.mook1594.biznavi.transactions.command;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BizNaviTransactionCommand {

	private String transactionId;
	private String startPlaceName;
	private String goalPlaceName;
	private int totalDistance;
	private boolean transactionFinished;

	@Builder
	public BizNaviTransactionCommand(
		final String transactionId,
		final String startPlaceName,
		final String goalPlaceName,
		final int totalDistance,
		final boolean transactionFinished
	) {
		this.transactionId = transactionId;
		this.startPlaceName = startPlaceName;
		this.goalPlaceName = goalPlaceName;
		this.totalDistance = totalDistance;
		this.transactionFinished = transactionFinished;
	}
}
