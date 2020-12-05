package com.mook1594.biznavi.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mook1594.biznavi.dto.BizNaviTransactionDto;

@ExtendWith(MockitoExtension.class)
public class BizNaviTransactionRepositoryTest {

	@Mock
	private BizNaviTransactionRepository bizNaviTransactionRepository;

	@Test
	public void insertTest() {
		BizNaviTransactionDto tb = new BizNaviTransactionDto(
			"abdd", "", "", 0, false
		);
		bizNaviTransactionRepository.save(tb);
	}
}
