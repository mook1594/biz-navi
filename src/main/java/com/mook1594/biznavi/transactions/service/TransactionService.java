package com.mook1594.biznavi.transactions.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;
import com.mook1594.biznavi.transactions.handler.data.NavigationDataHandlerResolver;
import com.mook1594.biznavi.transactions.repository.TransactionRepository;

import lombok.AllArgsConstructor;

@Service(value = "bizNavi-BizNaviTransactionService")
@AllArgsConstructor
public class TransactionService {

	private final TransactionRepository repository;

	@Transactional
	public Optional<TransactionDto> save(final NavigationData navigationData) {

		final String transactionId = navigationData.getLocation().getTransId();
		final Optional<TransactionDto> opDto = repository.findById(transactionId);
		Optional<TransactionDto> opTransaction = NavigationDataHandlerResolver.handle(navigationData, opDto);

		if(opTransaction.isPresent()) {
			return Optional.ofNullable(repository.save(opTransaction.get()));
		}
		return Optional.empty();
	}
}
