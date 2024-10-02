package com.example.javapatternsproject.common.ui.theme.themeholder;

public enum ProjectTheme {

    LIGHT,
    DARK,
    CUSTOM();//Тут пудут некоторые поля позже

    private CustomTheme customTheme;

    public CustomTheme getCustomTheme() {
        return customTheme;
    }

    public void setCustomTheme(CustomTheme customTheme) {
        if (this == CUSTOM) {
            this.customTheme = customTheme;
        } else {
            throw new UnsupportedOperationException("Только CUSTOM может содержать CustomTheme");
        }
    }

}
