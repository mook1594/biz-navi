package com.mook1594.biznavi.transactions.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mook1594.biznavi.common.mapping.MvcMapping;
import com.mook1594.biznavi.sample.SampleNavigationData;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.repository.TransactionRepository;
import com.mook1594.biznavi.transactions.service.TransactionService;

// @EnableMongoRepositories
// @ExtendWith(SpringExtension.class)
// @WebMvcTest({BizNaviTransactionController.class, BizNaviTransactionService.class, BizNaviTransactionRepository.class, MockBizNaviTransactionRepository.class})
public class BizNaviTransactionControllerTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private TransactionService service;

	private TransactionRepository repository;

	private MockMvc mockMvc;

	// @Autowired
	// UserController userController;
	//
	// private MockMvc mockMvc;
	//
	// @Before
	// public void setUp() throws Exception {
	// 	mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	// }

	@BeforeEach
	void init() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Disabled
	@Test
	public void test() throws Exception{
		NavigationData navigationData = SampleNavigationData.getNavigationStartData();

		mockMvc.perform(MockMvcRequestBuilders
			.post(MvcMapping.Url.TRANSACTION)
			.content(getJson(navigationData))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().is2xxSuccessful());
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
