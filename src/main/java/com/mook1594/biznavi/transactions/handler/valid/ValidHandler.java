package com.mook1594.biznavi.transactions.handler.valid;

import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public interface ValidHandler {
	boolean valid(final NavigationData navigationData, final BizNaviTransactionDto transactionDto);
}
