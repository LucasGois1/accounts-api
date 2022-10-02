package com.fintech.accountsapi.repository;

import com.fintech.accountsapi.repository.postgresql.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {}
