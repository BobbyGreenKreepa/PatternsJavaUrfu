package com.example.javapatternsproject.common.sdk.resources;

import android.content.Context;

public class SystemResourceProvider implements ResourceProvider {
    private final Context context;

    public SystemResourceProvider(Context context) {
        this.context = context;
    }

    @Override
    public String getString(int resId) {
        return context.getString(resId);
    }

    @Override
    public int getColor(int resId) {
        return context.getColor(resId);
    }
}
