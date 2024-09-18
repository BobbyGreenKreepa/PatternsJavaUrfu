package com.example.javapatternsproject.common.ui.theme.themeholder;

/**
 * Задание 2.
 * Singleton
 */
public class ThemeHolder {

    private static final ThemeHolder instance = new ThemeHolder();

    private ProjectTheme currentTheme = ProjectTheme.LIGHT;

    private ThemeHolder() {

    }

    /**
     * Получение текущей темы
     */
    public static ProjectTheme get() {
        return instance.currentTheme;
    }

    /**
     * Установка новой темы
     */
    public static void setTheme(ProjectTheme theme) {
        instance.currentTheme = theme;
    }
}

