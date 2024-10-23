package com.example.javapatternsproject.common.usecase.pattern;

import java.util.List;

abstract class Content {

    abstract String getText();

    abstract List<Content> getInners();
}
