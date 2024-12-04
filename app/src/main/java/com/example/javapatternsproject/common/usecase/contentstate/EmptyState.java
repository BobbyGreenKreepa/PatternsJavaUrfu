package com.example.javapatternsproject.common.usecase.contentstate;

import com.example.javapatternsproject.common.usecase.pattern.Content;

import java.util.Collections;
import java.util.List;

public class EmptyState extends ContentState {
    @Override
    String getText() {
        return "No content available.";
    }

    @Override
    List<Content> getInners() {
        return Collections.emptyList();
    }
}
