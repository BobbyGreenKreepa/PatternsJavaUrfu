package com.example.javapatternsproject.common.request;

public interface RequestFacade {

    Object getActualResponse(Request<Object> request);
}
