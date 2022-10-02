package com.fintech.accountsapi.repository.postgresql.adapters;

import com.fintech.accountsapi.domain.entities.account.Account;
import com.fintech.accountsapi.domain.entities.account.AccountGateway;
import com.fintech.accountsapi.domain.entities.account.AccountID;
import com.fintech.accountsapi.repository.AccountRepository;
import com.fintech.accountsapi.repository.postgresql.entities.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class AccountRepositoryPostgreSQL implements AccountGateway {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository
                .save(AccountEntity.fromDomain(account))
                .toDomain();
    }

    @Override
    public Optional<Account> findById(AccountID id) {
        return accountRepository
                .findById(id.getValue())
                .map(AccountEntity::toDomain);
    }
}
