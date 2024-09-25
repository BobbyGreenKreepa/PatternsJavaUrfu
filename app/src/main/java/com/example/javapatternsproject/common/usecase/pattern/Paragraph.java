package com.example.javapatternsproject.common.usecase.pattern;

import androidx.annotation.NonNull;

public record Paragraph(String header, String content, String moreLink) {

    /**
     * Задание 4 Prototype.
     * @return
     */
    public Paragraph copy() {
        return new Paragraph(header, content, moreLink);
    }

    // Проверка на пустой заголовок
    public boolean isNoHeader() {
        return header == null || header.isEmpty();
    }

    // Проверка на пустое содержимое
    public boolean isNoContent() {
        return content == null || content.isEmpty();
    }

    // Проверка на пустую ссылку "moreLink"
    public boolean isNoMoreLink() {
        return moreLink == null || moreLink.isEmpty();
    }

    @NonNull
    @Override
    public String toString() {
        return "Paragraph{" +
                "header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", moreLink='" + moreLink + '\'' +
                '}';
    }
}
