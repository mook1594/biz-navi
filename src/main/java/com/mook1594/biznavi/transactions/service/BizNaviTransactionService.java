package com.mook1594.biznavi.transactions.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.repository.BizNaviTransactionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BizNaviTransactionService {

	private final BizNaviTransactionRepository repository;

	public Optional<BizNaviTransactionDto> validate(final NavigationData navigationData) {
		//데이터 조회
		// final Optional<BizNaviTransactionDto> transaction = repository.
		// BizNaviTransactionDto dto = toBizNaviTransaction(navigationData);
		return null;
	}

	private BizNaviTransactionDto toBizNaviTransaction(final NavigationData navigationData) {
		return BizNaviTransactionDto.builder()
			.transactionId(navigationData.getLocationInfo().getTransId())
			.startPlaceName(navigationData.getLocationInfo().getStartName())
			.totalDistance(navigationData.getLocationInfo().getTotalDistance().doubleValue())
			.goalPlaceName(navigationData.getLocationInfo().getGoalName())
			.transactionFinished(false)
			.build();
	}
}
