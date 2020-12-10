package com.mook1594.biznavi.transactions.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mook1594.biznavi.transactions.command.BizNaviTransactionCommand;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.repository.BizNaviTransactionRepository;

@ExtendWith(MockitoExtension.class)
public class BizNaviTransactionServiceTest {

	@Mock
	private BizNaviTransactionRepository repository;

	@InjectMocks
	private BizNaviTransactionService service;

	@Test
	public void create() {
		final String transactionId = "test-001";
		BizNaviTransactionDto bizNaviTransaction = new BizNaviTransactionDto(transactionId, "성남시청", "카카오모빌리티", 5000, false);

		when(repository.save(any(BizNaviTransactionDto.class)))
			.thenReturn(bizNaviTransaction);

		BizNaviTransactionCommand command = getCommand(transactionId);
		Optional<BizNaviTransactionDto> result = service.create(command);

		assertEquals(true, result.isPresent());
		assertEquals(transactionId, result.get().getId());
	}

	private BizNaviTransactionCommand getCommand(final String transactionId) {
		return BizNaviTransactionCommand.builder()
			.transactionId(transactionId)
			.build();
	}
}
