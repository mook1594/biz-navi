package com.mook1594.biznavi.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mook1594.biznavi.transaction.dto.BizNaviTransactionDto;

@Repository
public interface BizNaviTransactionRepository extends MongoRepository<BizNaviTransactionDto, String> {

}
