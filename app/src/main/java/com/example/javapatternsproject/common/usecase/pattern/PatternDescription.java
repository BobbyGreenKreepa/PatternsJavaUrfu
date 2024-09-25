package com.example.javapatternsproject.common.usecase.pattern;

import java.util.Collections;
import java.util.List;

/**
 * Задание 3 StaticFabricMethod
 */
public class PatternDescription {
    private final String imageUrl;
    private final String header;
    private final List<Paragraph> paragraphs;

    // Приватный конструктор
    private PatternDescription(String imageUrl, String header, List<Paragraph> paragraphs) {
        this.imageUrl = imageUrl;
        this.header = header;
        this.paragraphs = paragraphs;
    }

    // Статический метод-конструктор для создания объекта с изображением
    public static PatternDescription withImageUrl(String imageUrl) {
        return new PatternDescription(imageUrl, "", Collections.emptyList());
    }

    // Статический метод-конструктор для создания объекта с заголовком
    public static PatternDescription withHeader(String header) {
        return new PatternDescription("", header, Collections.emptyList());
    }

    // Статический метод-конструктор для создания объекта с параграфами
    public static PatternDescription withParagraphs(List<Paragraph> paragraphs) {
        return new PatternDescription("", "", paragraphs);
    }

    public boolean isNoHeader() {
        return header == null || header.isEmpty();
    }

    public boolean isNoContent() {
        return paragraphs == null || paragraphs.isEmpty();
    }

    public boolean isNoImage() {
        return imageUrl == null || imageUrl.isEmpty();
    }

    @Override
    public String toString() {
        return "PatternDescription{" +
                "imageUrl='" + imageUrl + '\'' +
                ", header='" + header + '\'' +
                ", paragraphs=" + paragraphs +
                '}';
    }
}