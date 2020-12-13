package com.mook1594.biznavi.transactions.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.mock.MockBizNaviTransactionRepository;
import com.mook1594.biznavi.sample.SampleLocation;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

public class BizNaviTransactionServiceTest {

	private List<NavigationData> navigationDataList;
	private TransactionService service;
	private MockBizNaviTransactionRepository mockRepository;

	@BeforeEach
	public void init() {
		mockRepository = new MockBizNaviTransactionRepository();
		service = new TransactionService(mockRepository);
		navigationDataList = SampleLocation.navigationFromSeongNamCityHallToKakaoMobility();
	}

	@Test
	@DisplayName("네비게이션 시작 데이터 처리")
	public void start() {

		List<Optional<TransactionDto>> listTransaction = navigationDataList.stream()
			.map(d -> service.save(d))
			.collect(Collectors.toList());

		Optional<TransactionDto> opTransaction = listTransaction.get(listTransaction.size() - 1);

		assertTrue(opTransaction.isPresent());
		assertTrue(opTransaction.get().isWorkAccept());
	}
}
