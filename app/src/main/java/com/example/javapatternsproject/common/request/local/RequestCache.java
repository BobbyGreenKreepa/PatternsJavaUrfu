package com.example.javapatternsproject.common.request.local;

import com.example.javapatternsproject.common.request.Request;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestCache {

    private final SoftReference<Map<Request<Object>, Object>> cache =
            new SoftReference<>(new ConcurrentHashMap<>());

    private static final RequestCache INSTANCE = new RequestCache();

    private RequestCache() { }

    public static RequestCache get() {
        return INSTANCE;
    }

    public Object tryGet(Request<Object> request) {
        return cache.get().get(request);
    }

    public void set(Request<Object> request, Object resp) {
        cache.get().put(request, resp);
    }
}
