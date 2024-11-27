package com.example.javapatternsproject.common.eventbus;

@FunctionalInterface
public interface EventListener<T> {
    void onEvent(T event);
}