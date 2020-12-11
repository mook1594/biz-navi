package com.mook1594.biznavi.transactions.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mook1594.biznavi.sample.SampleNavigationData;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

@ExtendWith(MockitoExtension.class)
public class BizNaviTransactionServiceTest {

	@InjectMocks
	private BizNaviTransactionService service;

	@Test
	@DisplayName("네비게이션 데이터 받았을때 저장할 Dto로 변환")
	public void start() {
		NavigationData navigationData = SampleNavigationData.getNavigationStartDate();

		Optional<BizNaviTransactionDto> transaction = service.validate(navigationData);
		assertTrue(transaction.isPresent());
		assertEquals(1, transaction.get().getLocationInfos().size());
		assertEquals(navigationData.getLocationInfo().getTransId(), transaction.get().getId());
	}

}
