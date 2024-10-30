package com.example.javapatternsproject.common.logger;

public interface Logger {

    void log(String message);

    void logError(Throwable error, String message);
}
