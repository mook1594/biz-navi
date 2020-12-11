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



		return null;
	}
}
