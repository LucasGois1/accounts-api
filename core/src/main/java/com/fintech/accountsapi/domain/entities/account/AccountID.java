package com.fintech.accountsapi.domain.entities.account;

import com.fintech.accountsapi.domain.entities.Identifier;

import java.util.UUID;

public class AccountID extends Identifier {
    private final UUID value;

    public AccountID() {
        this.value = UUID.randomUUID();
    }

    public AccountID(final String value) {
        this.value = UUID.fromString(value);
    }

    @Override
    public String getValue() {
        return value.toString();
    }
}
