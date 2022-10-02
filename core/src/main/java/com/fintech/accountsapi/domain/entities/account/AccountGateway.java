package com.fintech.accountsapi.domain.entities.account;

import java.util.Optional;

public interface AccountGateway {
    Account save(Account account);

    Optional<Account> findById(AccountID id);
}
