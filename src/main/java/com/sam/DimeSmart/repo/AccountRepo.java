package com.sam.DimeSmart.repo;

import com.sam.DimeSmart.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
