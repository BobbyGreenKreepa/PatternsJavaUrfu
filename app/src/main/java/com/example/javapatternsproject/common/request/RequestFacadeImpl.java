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

    //Здаание 23 стратегия
    private final OnErrorStrategy onErrorStrategy;

    private final Api api;

    private final Logger logger;

    public RequestFacadeImpl(
            Api api,
            Logger logger,
            OnErrorStrategy onErrorStrategy
    ) {
        this.api = api;
        this.logger = logger;
        this.onErrorStrategy = onErrorStrategy;
    }

    @Override
    public Object getActualResponse(Request<Object> request) {
        try {
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
        } catch (Throwable e) {
            if (onErrorStrategy.shouldInterceptError(e)) {
                return onErrorStrategy.getValue(e);
            }

            throw e;
        }
    }

    public Api getApi() {
        return api;
    }

    public Logger getLogger() {
        return logger;
    }
}
