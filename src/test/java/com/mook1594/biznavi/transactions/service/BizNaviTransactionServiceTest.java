package com.mook1594.biznavi.transactions.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mook1594.biznavi.mock.MockBizNaviTransactionRepository;
import com.mook1594.biznavi.sample.SampleLocation;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public class BizNaviTransactionServiceTest {

	private List<NavigationData> navigationDataList;
	private List<BizNaviTransactionDto> transactionList = Lists.newArrayList();

	private BizNaviTransactionService service;

	private MockBizNaviTransactionRepository mockRepository;

	@BeforeEach
	public void init() {
		mockRepository = new MockBizNaviTransactionRepository();
		service = new BizNaviTransactionService(mockRepository);
		navigationDataList = SampleLocation.navigationFromSeongNamCityHallToKakaoMobility();
	}

	@Test
	@DisplayName("네비게이션 시작 데이터 처리")
	public void start() {

		Optional<BizNaviTransactionDto> opTransaction = navigationDataList.stream()
			.map(d -> service.save(d))
			.findAny()
			.orElse(Optional.empty());

		assertTrue(opTransaction.isPresent());
		System.out.println(getJson(opTransaction.get()));
	}

	private static String getJson(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (Exception ex) {
			return "";
		}
	}
}
