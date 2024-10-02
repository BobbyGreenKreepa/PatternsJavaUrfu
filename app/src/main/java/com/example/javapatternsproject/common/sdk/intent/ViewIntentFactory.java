package com.example.javapatternsproject.common.sdk.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class ViewIntentFactory extends IntentFactory {
    @Override
    public Intent createIntent(Context context, String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("URL не может быть пустым");
        }
        return new Intent(Intent.ACTION_VIEW, Uri.parse(data));
    }
}