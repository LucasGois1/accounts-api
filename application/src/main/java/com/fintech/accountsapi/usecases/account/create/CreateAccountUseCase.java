package com.fintech.accountsapi.usecases.account.create;

import com.fintech.accountsapi.domain.validation.ErrorNotification;
import com.fintech.accountsapi.usecases.UseCase;
import io.vavr.control.Either;

public abstract class CreateAccountUseCase extends UseCase<CreateAccountCommand, Either<ErrorNotification, CreateAccountResponse>> {}