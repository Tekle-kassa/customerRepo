package com.tekle.customer;

public record RegistrationRequest(
        String name,
        String email,
        Integer age
        ) {}
