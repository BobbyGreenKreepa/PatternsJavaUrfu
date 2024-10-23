package com.example.javapatternsproject.common.sdk.resources.decorator;

import android.util.Log;

import com.example.javapatternsproject.common.sdk.resources.ResourceProvider;

public class LoggerResourceProviderDecorator implements ResourceProvider {
    private final ResourceProvider resourceProvider;

    public LoggerResourceProviderDecorator(ResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    @Override
    public String getString(int resId) {
        String result = resourceProvider.getString(resId);
        Log.d("ResourceProvider", "getString() called with resId: " + resId + ", result: " + result);
        return result;
    }

    @Override
    public int getColor(int resId) {
        int result = resourceProvider.getColor(resId);
        Log.d("ResourceProvider", "getColor() called with resId: " + resId + ", result: " + result);
        return result;
    }
}
