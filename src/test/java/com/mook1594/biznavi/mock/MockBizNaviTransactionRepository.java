package com.mook1594.biznavi.mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mook1594.biznavi.transactions.dto.TransactionDto;
import com.mook1594.biznavi.transactions.repository.TransactionRepository;

public class MockBizNaviTransactionRepository implements TransactionRepository {

	private static final Map<String, TransactionDto> map = new HashMap<>();

	@Override
	public <S extends TransactionDto> S save(S s) {
		return (S) map.put(s.getTransactionId(), s);
	}

	@Override
	public <S extends TransactionDto> List<S> saveAll(Iterable<S> iterable) {
		return null;
	}

	@Override
	public Optional<TransactionDto> findById(String s) {
		return Optional.ofNullable(map.get(s));
	}

	@Override
	public boolean existsById(String s) {
		return false;
	}

	@Override
	public List<TransactionDto> findAll() {
		return null;
	}

	@Override
	public Iterable<TransactionDto> findAllById(Iterable<String> iterable) {
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
	public void delete(TransactionDto transactionDto) {

	}

	@Override
	public void deleteAll(Iterable<? extends TransactionDto> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public List<TransactionDto> findAll(Sort sort) {
		return null;
	}

	@Override
	public Page<TransactionDto> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends TransactionDto> S insert(S s) {
		return null;
	}

	@Override
	public <S extends TransactionDto> List<S> insert(Iterable<S> iterable) {
		return null;
	}

	@Override
	public <S extends TransactionDto> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends TransactionDto> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends TransactionDto> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public <S extends TransactionDto> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends TransactionDto> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends TransactionDto> boolean exists(Example<S> example) {
		return false;
	}
}
