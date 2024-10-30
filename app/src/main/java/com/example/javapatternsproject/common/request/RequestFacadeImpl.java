package com.example.javapatternsproject.common.request;

import com.example.javapatternsproject.common.logger.Logger;
import com.example.javapatternsproject.common.request.local.RequestCache;
import com.example.javapatternsproject.common.request.remote.Api;

import java.net.CacheRequest;


/**
 * Задание 12 Facade.
 * Данный класс - реализация интерфейса RequestFacade,
 * здесь сркрыта логика, призванная облегчить вызываемый код.
 */
public class RequestFacadeImpl implements RequestFacade {

    private final Api api;

    private final Logger logger;

    public RequestFacadeImpl(
            Api api,
            Logger logger
    ) {
        this.api = api;
        this.logger = logger;
    }

    @Override
    public Object getActualResponse(Request<Object> request) {
        Object respFromCache = RequestCache.get().tryGet(request);

        if (respFromCache == null) {
            Object resp = api.execute(request);
            logger.log("Request to sever" + request.url());
            RequestCache.get().set(request, resp);
            logger.log("Enclosed to cache \n" + resp.toString());
            return resp;
        }

        logger.log("====FROM CACHE====" + request.url());
        return respFromCache;
    }

    public Api getApi() {
        return api;
    }

    public Logger getLogger() {
        return logger;
    }
}
