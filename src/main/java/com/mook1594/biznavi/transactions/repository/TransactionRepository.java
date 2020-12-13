package com.mook1594.biznavi.transactions.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mook1594.biznavi.transactions.dto.TransactionDto;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionDto, String> {

}
