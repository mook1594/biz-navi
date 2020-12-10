package com.mook1594.biznavi.transactions.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mook1594.biznavi.transactions.command.BizNaviTransactionCommand;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.repository.BizNaviTransactionRepository;

import lombok.AllArgsConstructor;

@Service(value = "biznavi-BizNaviTransactionService")
@AllArgsConstructor
public class BizNaviTransactionService {

	private final BizNaviTransactionRepository bizNaviTransactionRepository;

	public Optional<BizNaviTransactionDto> create(final BizNaviTransactionCommand command) {
		BizNaviTransactionDto dto = BizNaviTransactionDto.fromCommand(command);
		return Optional.ofNullable(bizNaviTransactionRepository.save(dto));
	}
}
