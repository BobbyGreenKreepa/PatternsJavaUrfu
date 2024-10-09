package com.example.javapatternsproject.common.sdk.notification;

/**
 * Конкретные продукты для показа нативных Android уведомлений
 */

class AndroidTextNotification implements TextNotification {
    @Override
    public void sendText(String message) {
        // Логика отправки текстового уведомления
    }
}

class AndroidImageNotification implements ImageNotification {
    @Override
    public void sendImage(String imageUrl) {
        // Логика отправки изображенного уведомления
    }
}
