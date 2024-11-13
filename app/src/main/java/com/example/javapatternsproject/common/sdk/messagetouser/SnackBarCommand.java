package com.example.javapatternsproject.common.sdk.messagetouser;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarCommand implements NotificationCommand {
    private final View view;
    private final String message;
    private final String actionText;
    private final Runnable action;

    public SnackBarCommand(View view, String message, String actionText, Runnable action) {
        this.view = view;
        this.message = message;
        this.actionText = actionText;
        this.action = action;
    }

    @Override
    public void execute() {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        if (actionText != null && action != null) {
            snackbar.setAction(actionText, v -> action.run());
        }
        snackbar.show();
    }
}
