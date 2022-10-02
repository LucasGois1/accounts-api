package com.fintech.accountsapi.domain.validation;

import com.fintech.accountsapi.domain.exceptions.DomainException;

import java.util.ArrayList;
import java.util.List;

public class ErrorNotification implements ValidationHandler {

    private final List<Error> errors;

    private ErrorNotification(final List<Error> errors) {
        this.errors = errors;
    }

    public static ErrorNotification create() {
        return new ErrorNotification(new ArrayList<>());
    }

    public static ErrorNotification create(final Error anError) {
        return ErrorNotification.create().append(anError);
    }

    public static ErrorNotification create(final Throwable t) {
        return create(new Error(t.getMessage()));
    }

    @Override
    public ErrorNotification append(final Error anError) {
        this.errors.add(anError);
        return this;
    }

    @Override
    public ErrorNotification append(final ValidationHandler anHandler) {
        this.errors.addAll(anHandler.getErrors());
        return this;
    }

    @Override
    public <T> T validate(final Validation<T> aValidation) {
        try {
            return aValidation.validate();

        } catch (final DomainException ex) {
            this.errors.addAll(ex.getErrors());

        } catch (final Throwable t) {
            this.errors.add(new Error(t.getMessage()));
        }

        return null;
    }

    @Override
    public List<Error> getErrors() {
        return this.errors;
    }
}
