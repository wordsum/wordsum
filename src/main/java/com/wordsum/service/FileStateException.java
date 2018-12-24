package com.wordsum.service;

public class FileStateException extends RuntimeException {

    FileStateException(String message) { super(message); }

    FileStateException(String message, Throwable throwable) { super(message, throwable); }
}
