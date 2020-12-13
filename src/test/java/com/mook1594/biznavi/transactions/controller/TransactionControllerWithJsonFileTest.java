package com.mook1594.biznavi.transactions.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mook1594.biznavi.common.mapping.MvcMapping;
import com.mook1594.biznavi.transactions.command.TransactionCommand;
import com.mook1594.biznavi.transactions.dto.TransactionDto;

import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerWithJsonFileTest {

	@LocalServerPort
	int randomServerPort;

	private WebClient webClient;

	@BeforeEach
	void init() {
		webClient = WebClient.create("http://localhost:" + randomServerPort);
	}

	@Test
	@DisplayName("샘플데이터로 navi 시작데이터 부터 종료데이터까지 호출 테스트")
	public void test() throws Exception {
		final String sampleFilePath = "src/test/resources/SampleDataTest.json";
		final JSONParser parser = new JSONParser(new FileReader(sampleFilePath));
		final Object jsonObject = (Object) parser.parse();

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(jsonObject);

		List<TransactionCommand> commands = mapper.readValue(jsonString, new TypeReference<List<TransactionCommand>>() {
		});


		List<TransactionDto> results = Lists.newArrayList();
		final String tranId = "navi-test-0002";
		for(TransactionCommand command : commands) {
			results.add(
				call(command, tranId)
			);
		}

		assertEquals(results.size(), results.size());
		System.out.println(getJson(results.get(results.size() - 1)));
	}

	public TransactionDto call(final TransactionCommand command, final String tranId) {
		command.getLocation().setTransId(tranId);

		return webClient.post()
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
