package com.fintech.accountsapi.usecases.account.create;

public record CreateAccountCommand(
    String name,
    String email
) {
    public static CreateAccountCommand of(final String name, final String email) {
        return new CreateAccountCommand(name, email);
    }
}
