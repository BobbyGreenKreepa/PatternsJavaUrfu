package com.example.javapatternsproject.common.usecase.contentstate;

import com.example.javapatternsproject.common.usecase.pattern.Content;

import java.util.Collections;
import java.util.List;

public abstract class ContentState {
    abstract String getText();

    abstract List<Content> getInners();
}

