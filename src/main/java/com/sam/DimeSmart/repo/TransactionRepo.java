package com.sam.DimeSmart.repo;

import com.sam.DimeSmart.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction,Long> {
    List<Transaction> findByAccountIdOrderByTimestampDesc(Long accountId);
}
