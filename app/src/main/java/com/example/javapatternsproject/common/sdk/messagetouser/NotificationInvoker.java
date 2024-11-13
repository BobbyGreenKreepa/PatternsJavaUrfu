package com.example.javapatternsproject.common.sdk.messagetouser;

import java.util.ArrayList;
import java.util.List;

/**
 * Задание 16 Command
 * Класс вызываюший и агрегирующий сообщения для пользователя
 */
public class NotificationInvoker {
    private final List<NotificationCommand> notificationHistory = new ArrayList<>();

    public void executeCommand(NotificationCommand command) {
        command.execute();
        notificationHistory.add(command);
    }

    public void clearHistory() {
        notificationHistory.clear();
    }
}
