package com.example.javapatternsproject.common.usecase.pattern;

import java.util.List;

public abstract class Content {

    abstract String getText();

    abstract List<Content> getInners();
}
