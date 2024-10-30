package com.example.javapatternsproject.common.request.remote;

import com.example.javapatternsproject.common.request.Request;

public interface Api {

    Object execute(Request<Object> request);
}
