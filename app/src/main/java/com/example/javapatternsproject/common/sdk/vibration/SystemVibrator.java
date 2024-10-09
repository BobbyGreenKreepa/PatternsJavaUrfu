package com.example.javapatternsproject.common.sdk.vibration;

import android.os.Vibrator;

/**
 * Adaptee, использует системный класс Vibrator, жестко связан с фреймворком для вибрирования
 */

class SystemVibrator {
    private final Vibrator vibrator;

    public SystemVibrator(Vibrator vibrator) {
        this.vibrator = vibrator;
    }

    public void vibrate(long milliseconds) {
        vibrator.vibrate(milliseconds);
    }

    public void cancel() {
        vibrator.cancel();
    }
}