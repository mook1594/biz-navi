package com.mook1594.biznavi.transactions.handler;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.sample.SampleLocation;
import com.mook1594.biznavi.sample.SampleNavigationData;
import com.mook1594.biznavi.transactions.command.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.handler.data.NavigationDataHandlerResolver;
import com.mook1594.biznavi.transactions.handler.data.StartNavigationDataHandler;

public class NavigationDataResolversTest {

	List<NavigationData> navigationDataList;

	@BeforeEach
	public void init() {
		navigationDataList = SampleLocation.navigationFromSeongNamCityHallToKakaoMobility();
	}

	@Test
	@DisplayName("네비게이션 시작 데이터 처리")
	public void startHandler() {
		final NavigationData data = navigationDataList.get(0);

		Optional<BizNaviTransactionDto> dto = NavigationDataHandlerResolver.handle(data, Optional.empty());

		assertTrue(dto.isPresent());
		assertEquals(1, dto.get().getLocationInfos().size());
		assertEquals(data.getLocation().getTransId(), dto.get().getTransactionId());
	}

	@Test
	@DisplayName("네비게이션 업데이트 데이터 처리")
	public void updateHandlerValid() {
		final Optional<BizNaviTransactionDto> transaction = find();
		final NavigationData data = navigationDataList.get(1);

		Optional<BizNaviTransactionDto> dto = NavigationDataHandlerResolver.handle(data, transaction);

		assertTrue(dto.isPresent());
		assertEquals(2, dto.get().getLocationInfos().size());
		assertEquals(data.getLocation().getTransId(), dto.get().getTransactionId());
		assertEquals(data.getLocation().getLocation(), dto.get().getLocationInfos().get(1).getLocation());
	}

	@Test
	@DisplayName("네비게이션 업데이트 데이터 처리")
	public void updateHandlerInValid() {
		final Optional<BizNaviTransactionDto> transaction = find();
		final NavigationData data = SampleNavigationData.getNavigationUpdateData();

		Optional<BizNaviTransactionDto> dto = NavigationDataHandlerResolver.handle(data, transaction);

		assertTrue(dto.isPresent());
		assertEquals(1, dto.get().getLocationInfos().size());
	}

	@Test
	@DisplayName("네비게이션 종료 데이터 처리")
	public void endHandler() {
		final Optional<BizNaviTransactionDto> transaction = find();
		final NavigationData data = navigationDataList.get(navigationDataList.size() - 1);

		Optional<BizNaviTransactionDto> dto = NavigationDataHandlerResolver.handle(data, transaction);

		assertTrue(dto.isPresent());
		assertEquals(2, dto.get().getLocationInfos().size());
		assertEquals(data.getLocation().getTransId(), dto.get().getTransactionId());
		assertEquals(data.getLocation().getLocation(), dto.get().getLocationInfos().get(1).getLocation());
	}

	private Optional<BizNaviTransactionDto> find() {
		final NavigationData data = navigationDataList.get(0);
		Optional<BizNaviTransactionDto> dto = new StartNavigationDataHandler().resolveNavigationData(data, Optional.empty());

		return dto;
	}
}
