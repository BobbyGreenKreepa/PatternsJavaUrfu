package com.example.javapatternsproject.common.sdk.intent;

import android.content.Context;
import android.content.Intent;

public abstract class IntentFactory {
    public abstract Intent createIntent(Context context, String data);
}
