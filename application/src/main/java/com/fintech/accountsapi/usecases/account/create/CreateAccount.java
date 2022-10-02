package com.fintech.accountsapi.usecases.account.create;

import com.fintech.accountsapi.domain.entities.account.AccountGateway;
import com.fintech.accountsapi.domain.validation.ErrorNotification;
import com.fintech.accountsapi.domain.entities.account.Account;
import io.vavr.control.Either;

import static io.vavr.API.*;

public class CreateAccount extends CreateAccountUseCase {

    private final AccountGateway accountGateway;

    public CreateAccount(final AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    @Override
    public Either<ErrorNotification, CreateAccountResponse> execute(final CreateAccountCommand request) {

        final var notification = ErrorNotification.create();

        final var account = new Account(
                request.name(),
                request.email()
        );

        account.validate(notification);

        return notification.hasError() ? Left(notification) : create(account);
    }

    private Either<ErrorNotification, CreateAccountResponse> create(final Account account) {
        return Try(() -> this.accountGateway.save(account))
                .toEither()
                .bimap(ErrorNotification::create, CreateAccountResponse::from);
    }
}
