package com.mook1594.biznavi.transactions.handler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.sample.SampleNavigationData;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

public class NavigationDataResolversTest {

	@Test
	@DisplayName("네비게이션 시작 데이터 처리")
	public void startHandler() {
		final NavigationData data = SampleNavigationData.getNavigationStartDate();

		Optional<BizNaviTransactionDto> dto = NavigationDataHandlerManager.handle(data, Optional.empty());

		assertTrue(dto.isPresent());
		assertEquals(1, dto.get().getLocationInfos().size());
		assertEquals(data.getLocationInfo().getTransId(), dto.get().getId());
	}

	@Test
	@DisplayName("네비게이션 업데이트 데이터 처리")
	public void updateHandler() {
		final Optional<BizNaviTransactionDto> transaction = find();
		final NavigationData data = SampleNavigationData.getNavigationUpdateDate();

		Optional<BizNaviTransactionDto> dto = NavigationDataHandlerManager.handle(data, transaction);

		assertTrue(dto.isPresent());
		assertEquals(2, dto.get().getLocationInfos().size());
		assertEquals(data.getLocationInfo().getTransId(), dto.get().getId());
		assertEquals(data.getLocationInfo().getLat().toString(), dto.get().getLocationInfos().get(1).getLat());
		assertEquals(data.getLocationInfo().getLng().toString(), dto.get().getLocationInfos().get(1).getLng());
	}

	@Test
	@DisplayName("네비게이션 종료 데이터 처리")
	public void endHandler() {
		final Optional<BizNaviTransactionDto> transaction = find();
		final NavigationData data = SampleNavigationData.getNavigationEndDate();

		Optional<BizNaviTransactionDto> dto = NavigationDataHandlerManager.handle(data, transaction);

		assertTrue(dto.isPresent());
		assertEquals(2, dto.get().getLocationInfos().size());
		assertEquals(data.getLocationInfo().getTransId(), dto.get().getId());
		assertEquals(data.getLocationInfo().getLat().toString(), dto.get().getLocationInfos().get(1).getLat());
		assertEquals(data.getLocationInfo().getLng().toString(), dto.get().getLocationInfos().get(1).getLng());
	}

	private Optional<BizNaviTransactionDto> find() {
		final NavigationData data = SampleNavigationData.getNavigationStartDate();
		Optional<BizNaviTransactionDto> dto = new StartNavigationDataHandler().resolveNavigationData(data, Optional.empty());

		return dto;
	}
}
