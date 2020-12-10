package com.mook1594.biznavi.transactions.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mook1594.biznavi.transactions.dto.BizNaviTransactionDto;

@Repository
public interface BizNaviTransactionRepository extends MongoRepository<BizNaviTransactionDto, String> {

}
