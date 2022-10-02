package com.fintech.accountsapi.usecases.account.create;

import com.fintech.accountsapi.domain.entities.account.Account;

public record CreateAccountResponse(
    String id
) {
    public static CreateAccountResponse from(final Account account) {
        return new CreateAccountResponse(account.getId().getValue());
    }
}
