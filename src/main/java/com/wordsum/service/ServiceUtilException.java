package com.wordsum.service;

public class ServiceUtilException extends RuntimeException {

    public ServiceUtilException(String message) { super(message); }

    public ServiceUtilException(String message, Throwable cause) { super(message, cause); }
}
