package com.fintech.accountsapi.restapi.controllers.account;

import com.fintech.accountsapi.domain.validation.ErrorNotification;
import com.fintech.accountsapi.usecases.account.create.CreateAccountCommand;
import com.fintech.accountsapi.usecases.account.create.CreateAccountResponse;
import com.fintech.accountsapi.usecases.account.create.CreateAccountUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.function.Function;

@RestController
public class AccountController implements AccountAPI {

    private final CreateAccountUseCase createAccountUseCase;

    public AccountController(final CreateAccountUseCase createAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
    }

    @Override
    public ResponseEntity<?> createAccount(CreateAccountRequest request) {
        final var aCommand = CreateAccountCommand.of(request.name(), request.email());

        final Function<ErrorNotification, ResponseEntity<?>> onError =
                error -> ResponseEntity
                                    .unprocessableEntity()
                                    .body(error);

        final Function<CreateAccountResponse, ResponseEntity<?>> onSuccess =
                response -> ResponseEntity
                                    .created(URI.create("/accounts/" + response.id()))
                                    .body(response);

        return this.createAccountUseCase.execute(aCommand)
                                        .fold(onError, onSuccess);
    }
}
