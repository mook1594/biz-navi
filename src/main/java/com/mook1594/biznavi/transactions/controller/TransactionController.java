package com.mook1594.biznavi.transactions.controller;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mook1594.biznavi.common.mapping.MvcMapping;
import com.mook1594.biznavi.transactions.command.TransactionCommand;
import com.mook1594.biznavi.transactions.domain.NavigationData;
import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.service.TransactionService;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@RestController
@RequestMapping(MvcMapping.Url.TRANSACTION)
@AllArgsConstructor
public class TransactionController {

	@Resource(name = "bizNavi-BizNaviTransactionService")
	private final TransactionService service;

	@PostMapping
	public ResponseEntity post(@RequestBody @NonNull final TransactionCommand command) {
		final NavigationData navigationData = command.toNavigationData();
		Optional<BizNaviTransactionDto> dto = service.save(navigationData);
		if(dto.isPresent()) {
			return new ResponseEntity(dto.get(), HttpStatus.OK);
		}
		return new ResponseEntity(null, HttpStatus.NO_CONTENT);
	}
}

