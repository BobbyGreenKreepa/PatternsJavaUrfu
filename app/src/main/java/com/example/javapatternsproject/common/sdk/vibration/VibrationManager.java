package com.example.javapatternsproject.common.sdk.vibration;

/**
 * Интерфейс для вызывающего кода для работы с вибрацией
 */

interface VibrationManager {
    void vibrate(long duration);
    void stopVibration();
}
