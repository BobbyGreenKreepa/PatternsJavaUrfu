package com.example.javapatternsproject.common.sdk.messagetouser;

import android.content.Context;
import android.widget.Toast;

public class ToastCommand implements NotificationCommand {
    private final Context context;
    private final String message;

    public ToastCommand(Context context, String message) {
        this.context = context;
        this.message = message;
    }

    @Override
    public void execute() {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}