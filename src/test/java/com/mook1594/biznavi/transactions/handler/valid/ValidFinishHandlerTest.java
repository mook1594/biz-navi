package com.mook1594.biznavi.transactions.handler.valid;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mook1594.biznavi.sample.SampleLocation;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;
import com.mook1594.biznavi.transactions.handler.data.EndNavigationDataHandler;
import com.mook1594.biznavi.transactions.handler.data.StartNavigationDataHandler;
import com.mook1594.biznavi.transactions.handler.data.UpdateNavigationDataHandler;

public class ValidFinishHandlerTest {

	private StartNavigationDataHandler startHandler;
	private UpdateNavigationDataHandler updateHandler;
	private EndNavigationDataHandler endHandler;
	private List<NavigationData> navigationDataList;

	@BeforeEach
	public void init() {
		startHandler = new StartNavigationDataHandler();
		updateHandler = new UpdateNavigationDataHandler();
		endHandler = new EndNavigationDataHandler();
		navigationDataList = SampleLocation.navigationFromSeongNamCityHallToKakaoMobility();
	}


	@Test
	@DisplayName("종료 후 데이터 저장안되는지 확인")
	public void finish() {
		Optional<TransactionDto> transactionDto = find();
		NavigationData lastData = navigationDataList.get(navigationDataList.size() - 1);
		endHandler.resolveNavigationData(lastData, transactionDto);
		updateHandler.resolveNavigationData(navigationDataList.get(4), transactionDto);

		assertEquals(3, transactionDto.get().getLocationInfos().size());
	}

	private Optional<TransactionDto> find() {

		Optional<TransactionDto> dto = startHandler.resolveNavigationData(navigationDataList.get(0),
			Optional.empty());

		updateHandler.resolveNavigationData(navigationDataList.get(1), dto);
		updateHandler.resolveNavigationData(navigationDataList.get(2), dto);


		return dto;
	}
}
