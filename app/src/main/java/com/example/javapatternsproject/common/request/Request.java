package com.example.javapatternsproject.common.request;

public record Request<T>(T body, String url) {

}