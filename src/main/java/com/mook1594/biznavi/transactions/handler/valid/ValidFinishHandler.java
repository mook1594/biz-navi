package com.mook1594.biznavi.transactions.handler.valid;

import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

public class ValidFinishHandler implements ValidHandler {

	@Override
	public boolean valid(NavigationData navigationData, TransactionDto transactionDto) {
		return !transactionDto.isFinish();
	}
}
