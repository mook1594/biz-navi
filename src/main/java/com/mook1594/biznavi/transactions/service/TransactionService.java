package com.mook1594.biznavi.transactions.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.handler.data.NavigationDataHandlerResolver;
import com.mook1594.biznavi.transactions.repository.TransactionRepository;

import lombok.AllArgsConstructor;

@Service(value = "bizNavi-BizNaviTransactionService")
@AllArgsConstructor
public class TransactionService {

	private final TransactionRepository repository;

	public Optional<BizNaviTransactionDto> save(final NavigationData navigationData) {

		final String transactionId = navigationData.getLocation().getTransId();
		final Optional<BizNaviTransactionDto> opDto = repository.findById(transactionId);
		Optional<BizNaviTransactionDto> opTransaction = NavigationDataHandlerResolver.handle(navigationData, opDto);

		if(opTransaction.isPresent()) {
			return Optional.ofNullable(repository.save(opTransaction.get()));
		}
		return Optional.empty();
	}
}
