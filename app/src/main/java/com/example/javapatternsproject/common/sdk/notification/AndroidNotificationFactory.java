package com.example.javapatternsproject.common.sdk.notification;

class AndroidNotificationFactory implements NotificationFactory {
    @Override
    public TextNotification createTextNotification() {
        return new AndroidTextNotification();
    }

    @Override
    public ImageNotification createImageNotification() {
        return new AndroidImageNotification();
    }
}
