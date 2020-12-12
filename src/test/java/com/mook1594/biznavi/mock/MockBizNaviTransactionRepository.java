package com.mook1594.biznavi.mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;
import com.mook1594.biznavi.transactions.repository.BizNaviTransactionRepository;

public class MockBizNaviTransactionRepository implements BizNaviTransactionRepository {

	private static final Map<String, BizNaviTransactionDto> map = new HashMap<>();

	@Override
	public <S extends BizNaviTransactionDto> S save(S s) {
		return (S) map.put(s.getId(), s);
	}

	@Override
	public <S extends BizNaviTransactionDto> List<S> saveAll(Iterable<S> iterable) {
		return null;
	}

	@Override
	public Optional<BizNaviTransactionDto> findById(String s) {
		return Optional.ofNullable(map.get(s));
	}

	@Override
	public boolean existsById(String s) {
		return false;
	}

	@Override
	public List<BizNaviTransactionDto> findAll() {
		return null;
	}

	@Override
	public Iterable<BizNaviTransactionDto> findAllById(Iterable<String> iterable) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(String s) {

	}

	@Override
	public void delete(BizNaviTransactionDto transactionDto) {

	}

	@Override
	public void deleteAll(Iterable<? extends BizNaviTransactionDto> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public List<BizNaviTransactionDto> findAll(Sort sort) {
		return null;
	}

	@Override
	public Page<BizNaviTransactionDto> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends BizNaviTransactionDto> S insert(S s) {
		return null;
	}

	@Override
	public <S extends BizNaviTransactionDto> List<S> insert(Iterable<S> iterable) {
		return null;
	}

	@Override
	public <S extends BizNaviTransactionDto> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends BizNaviTransactionDto> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends BizNaviTransactionDto> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public <S extends BizNaviTransactionDto> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends BizNaviTransactionDto> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends BizNaviTransactionDto> boolean exists(Example<S> example) {
		return false;
	}
}
