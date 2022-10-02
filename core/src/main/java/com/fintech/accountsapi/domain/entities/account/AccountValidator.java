package com.fintech.accountsapi.domain.entities.account;

import com.fintech.accountsapi.domain.validation.Error;
import com.fintech.accountsapi.domain.validation.ValidationHandler;
import com.fintech.accountsapi.domain.validation.Validator;

public class AccountValidator extends Validator {

    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 3;
    private final Account account;

    public AccountValidator(final Account aAccount, final ValidationHandler aHandler) {
        super(aHandler);
        this.account = aAccount;
    }

    @Override
    public void validate() {
        checkNameConstraints();
        checkEmailConstraints();
    }

    private void checkNameConstraints() {
        final var name = this.account.getName();

        if (name == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
            return;
        }

        if (name.isBlank()) {
            this.validationHandler().append(new Error("'name' should not be empty"));
            return;
        }

        final int length = name.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
        }
    }

    private void checkEmailConstraints() {
        final var email = this.account.getEmail();

        if (email == null) {
            this.validationHandler().append(new Error("'email' should not be null"));
            return;
        }

        if (email.isBlank()) {
            this.validationHandler().append(new Error("'email' should not be empty"));
            return;
        }

        final int length = email.trim().length();
        if (length > NAME_MAX_LENGTH || length < NAME_MIN_LENGTH) {
            this.validationHandler().append(new Error("'email' must be between 3 and 255 characters"));
        }

        // regex for email validation
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            this.validationHandler().append(new Error("'email' must be a valid email address"));
        }
    }
}
