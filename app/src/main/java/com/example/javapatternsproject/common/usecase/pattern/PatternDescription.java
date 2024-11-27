package com.example.javapatternsproject.common.usecase.pattern;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Задание 3 StaticFabricMethod + Snapshot with SharedPreferences
 */
public class PatternDescription {
    private final String imageUrl;
    private final String header;
    private final List<Paragraph> paragraphs;

    private static final String PREF_NAME = "PatternDescriptionPrefs";
    private static final String KEY_IMAGE_URL = "imageUrl";
    private static final String KEY_HEADER = "header";
    private static final String KEY_PARAGRAPHS = "paragraphs"; // Список будет сериализован

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

    /**
     * Задание 20 StaticFabricMethod + Snapshot with SharedPreferences
     */
    public static class Snapshot {
        private final String imageUrl;
        private final String header;
        private final List<Paragraph> paragraphs;

        private Snapshot(String imageUrl, String header, List<Paragraph> paragraphs) {
            this.imageUrl = imageUrl;
            this.header = header;
            this.paragraphs = paragraphs;
        }

        private String getImageUrl() {
            return imageUrl;
        }

        private String getHeader() {
            return header;
        }

        private List<Paragraph> getParagraphs() {
            return paragraphs;
        }
    }

    public Snapshot saveToSnapshot() {
        return new Snapshot(imageUrl, header, paragraphs);
    }

    public static PatternDescription restoreFromSnapshot(Snapshot snapshot) {
        return new PatternDescription(snapshot.getImageUrl(), snapshot.getHeader(), snapshot.getParagraphs());
    }

    public void saveToPreferences(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_IMAGE_URL, imageUrl);
        editor.putString(KEY_HEADER, header);
        editor.putString(KEY_PARAGRAPHS, serializeParagraphs(paragraphs));
        editor.apply();
    }

    public static PatternDescription restoreFromPreferences(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String imageUrl = preferences.getString(KEY_IMAGE_URL, "");
        String header = preferences.getString(KEY_HEADER, "");
        List<Paragraph> paragraphs = deserializeParagraphs(preferences.getString(KEY_PARAGRAPHS, ""));
        return new PatternDescription(imageUrl, header, paragraphs);
    }

    private static String serializeParagraphs(List<Paragraph> paragraphs) {
        if (paragraphs == null || paragraphs.isEmpty()) {
            return "";
        }
        StringBuilder serialized = new StringBuilder();
        for (Paragraph paragraph : paragraphs) {
            serialized.append(paragraph.toString()).append("||");
        }
        return serialized.toString();
    }

    private static List<Paragraph> deserializeParagraphs(String serialized) {
        if (serialized == null || serialized.isEmpty()) {
            return Collections.emptyList();
        }
        String[] items = serialized.split("\\|\\|");
        return Stream.of(items).map(Paragraph::fromString).toList();
    }
}
