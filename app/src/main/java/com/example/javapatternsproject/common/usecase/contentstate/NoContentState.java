package com.example.javapatternsproject.common.usecase.contentstate;

import com.example.javapatternsproject.common.usecase.pattern.Content;

import java.util.Collections;
import java.util.List;

public class NoContentState extends ContentState {
    private final String header;

    public NoContentState(String header) {
        this.header = header;
    }

    public NoContentState() {
        this.header = "Не заполнено";
    }

    @Override
    String getText() {
        return header;
    }

    @Override
    List<Content> getInners() {
        return Collections.emptyList();
    }
}
