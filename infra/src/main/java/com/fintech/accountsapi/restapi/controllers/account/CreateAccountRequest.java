package com.fintech.accountsapi.restapi.controllers.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateAccountRequest(
    @JsonProperty("name") String name,
    @JsonProperty("email") String email
){}
