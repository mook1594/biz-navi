package com.mook1594.biznavi.transactions.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

import com.mook1594.biznavi.common.mapping.MvcMapping;
import com.mook1594.biznavi.sample.SampleNavigationData;
import com.mook1594.biznavi.transactions.command.LocationInfoCommand;
import com.mook1594.biznavi.transactions.command.TransactionCommand;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BizNaviTransactionControllerTest {

	@LocalServerPort
	int randomServerPort;

	private WebClient webClient;

	@BeforeEach
	void init() {
		webClient = WebClient.create("http://localhost:" + randomServerPort);
	}

	@Test
	public void test() {
		TransactionCommand command = getCommand();

		TransactionDto dto = webClient.post()
			.uri(MvcMapping.Url.TRANSACTION)
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.bodyValue(command)
			.retrieve()
			.onStatus(s -> !s.is2xxSuccessful(),
				r -> Mono.error(new RuntimeException("not success")))
			.bodyToMono(TransactionDto.class)
			.flux()
			.toStream()
			.findFirst()
			.orElse(null);

		assertNotNull(dto);
	}

	private TransactionCommand getCommand() {
		NavigationData navigationData = SampleNavigationData.getNavigationStartData();
		TransactionCommand command = new TransactionCommand();
		command.setType(navigationData.getType().getCode());
		command.setLocation(new LocationInfoCommand());
		command.getLocation().setTransId(navigationData.getLocation().getTransId());
		command.getLocation().setDateTime(navigationData.getLocation().getTransId());
		command.getLocation().setTotalDistance(navigationData.getLocation().getTotalDistance().intValue());
		command.getLocation().setRemainDistance(navigationData.getLocation().getRemainDistance().intValue());
		command.getLocation().setStartName(navigationData.getLocation().getStartName());
		command.getLocation().setGoalName(navigationData.getLocation().getGoalName());
		command.getLocation().setLat(navigationData.getLocation().getLat().toString());
		command.getLocation().setLng(navigationData.getLocation().getLng().toString());

		return command;
	}
}
