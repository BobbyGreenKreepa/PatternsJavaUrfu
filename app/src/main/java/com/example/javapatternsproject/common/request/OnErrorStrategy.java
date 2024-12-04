package com.example.javapatternsproject.common.request;

//Задание 23
public interface OnErrorStrategy {

    Boolean shouldInterceptError(Throwable error);

    Object getValue(Throwable error);
}
