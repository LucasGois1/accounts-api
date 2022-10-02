package com.fintech.accountsapi.domain.entities.account;

import com.fintech.accountsapi.domain.entities.AggregateRoot;
import com.fintech.accountsapi.domain.validation.ValidationHandler;

public class Account extends AggregateRoot<AccountID> {

    private final String name;
    private final String email;

    public Account(final String id, final String name, final String email) {
        super(new AccountID(id));
        this.name = name;
        this.email = email;
    }

    public Account(final String name, final String email) {
        super(new AccountID());
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void validate(ValidationHandler handler) {
        new AccountValidator(this, handler).validate();
    }
}
