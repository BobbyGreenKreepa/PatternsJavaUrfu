package com.example.javapatternsproject.common.sdk.vibration;

import android.os.Vibrator;

/**
 * Класс адаптер
 */

class VibratorAdapter implements VibrationManager {
    private final SystemVibrator systemVibrator;

    public VibratorAdapter(Vibrator vibrator) {
        this.systemVibrator = new SystemVibrator(vibrator);
    }

    @Override
    public void vibrate(long duration) {
        systemVibrator.vibrate(duration);
    }

    @Override
    public void stopVibration() {
        systemVibrator.cancel();
    }
}
