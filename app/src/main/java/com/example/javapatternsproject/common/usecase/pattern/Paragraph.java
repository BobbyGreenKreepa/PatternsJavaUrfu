package com.example.javapatternsproject.common.usecase.pattern;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.List;

public class Paragraph extends Content {

    String header;

    String moreLink;

    String content;

    List<Content> inners;

    Paragraph (String header, String content, String moreLink) {
        this.content = content;
        this.header = header;
        this.moreLink = moreLink;
    }


    /**
     * Задание 4 Prototype.
     * @return
     */
    public Paragraph copy() {
        return new Paragraph(header, content, moreLink);
    }

    public boolean isNoHeader() {
        return header == null || header.isEmpty();
    }

    public boolean isNoContent() {
        return content == null || content.isEmpty();
    }

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

    public static Paragraph fromString(String serialized) {
        if (serialized == null || serialized.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        String[] parts = serialized.split("\\|", -1);
        if (parts.length < 3) {
            throw new IllegalArgumentException("Input string must have at least three parts: header, content, and moreLink");
        }

        String header = parts[0];
        String content = parts[1];
        String moreLink = parts[2];

        // Возвращаем новый объект
        return new Paragraph(header, content, moreLink);
    }

    @Override
    String getText() {
        return content;
    }

    @Override
    List<Content> getInners() {
        return inners;
    }
}
