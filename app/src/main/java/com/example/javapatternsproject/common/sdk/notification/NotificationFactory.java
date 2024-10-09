package com.example.javapatternsproject.common.sdk.notification;

/**
 * Абстрактная фабрика, абстрактные продукты
 */

interface NotificationFactory {
    TextNotification createTextNotification();
    ImageNotification createImageNotification();
}

interface TextNotification {
    void sendText(String message);
}

interface ImageNotification {
    void sendImage(String imageUrl);
}