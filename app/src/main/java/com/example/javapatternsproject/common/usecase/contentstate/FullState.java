package com.example.javapatternsproject.common.usecase.contentstate;

import com.example.javapatternsproject.common.usecase.pattern.Content;

import java.util.List;

public class FullState extends ContentState {
    private final String content;
    private final List<Content> inners;

    public FullState(String content, List<Content> inners) {
        this.content = content;
        this.inners = inners;
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
