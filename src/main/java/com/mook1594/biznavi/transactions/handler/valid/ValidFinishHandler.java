package com.mook1594.biznavi.transactions.handler.valid;

import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public class ValidFinishHandler implements ValidHandler {

	@Override
	public boolean valid(NavigationData navigationData, BizNaviTransactionDto transactionDto) {
		return !transactionDto.isFinish();
	}
}
