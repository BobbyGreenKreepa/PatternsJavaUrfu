package com.example.javapatternsproject.common.sdk.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class DialIntentFactory extends IntentFactory {

    @Override
    public Intent createIntent(Context context, String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Номер телефона не может быть пустым");
        }
        return new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + data));
    }
}