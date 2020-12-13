package com.mook1594.biznavi.transactions.handler.valid;

import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

public interface ValidHandler {
	boolean valid(final NavigationData navigationData, final TransactionDto transactionDto);
}
