package com.example.javapatternsproject.common.ui.theme.themeholder;

public class CustomTheme {
    private final String primaryColor;
    private final String secondaryColor;
    private final String font;
    private final String backgroundColor;
    private final int textSize;

    private CustomTheme(Builder builder) {
        this.primaryColor = builder.primaryColor;
        this.secondaryColor = builder.secondaryColor;
        this.font = builder.font;
        this.backgroundColor = builder.backgroundColor;
        this.textSize = builder.textSize;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public String getFont() {
        return font;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public static class Builder {
        private String primaryColor;
        private String secondaryColor;
        private String font;
        private String backgroundColor;
        private int textSize;

        public Builder setPrimaryColor(String primaryColor) {
            this.primaryColor = primaryColor;
            return this;
        }

        public Builder setSecondaryColor(String secondaryColor) {
            this.secondaryColor = secondaryColor;
            return this;
        }

        public Builder setFont(String font) {
            this.font = font;
            return this;
        }

        public Builder setBackgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public CustomTheme build() {
            return new CustomTheme(this);
        }
    }
}
