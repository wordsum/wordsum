package com.wordsum.service;

public class NlpStateException extends RuntimeException {

    NlpStateException(String message) { super(message); }

    NlpStateException(String message, Throwable throwable) { super(message, throwable); }
}
