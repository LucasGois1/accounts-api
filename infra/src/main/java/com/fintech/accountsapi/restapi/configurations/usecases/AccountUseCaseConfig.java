package com.fintech.accountsapi.restapi.configurations.usecases;

import com.fintech.accountsapi.domain.entities.account.AccountGateway;
import com.fintech.accountsapi.usecases.account.create.CreateAccount;
import com.fintech.accountsapi.usecases.account.create.CreateAccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountUseCaseConfig {

    private final AccountGateway accountGateway;

    public AccountUseCaseConfig(final AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    @Bean
    public CreateAccountUseCase createAccountUseCase() {
        return new CreateAccount(accountGateway);
    }
}
