package com.davioooh.srr.services;

public class TokenVerificationException extends RuntimeException {
    public TokenVerificationException(Throwable t) {
        super(t);
    }
}
