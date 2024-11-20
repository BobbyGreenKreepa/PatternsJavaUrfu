package com.example.javapatternsproject.common.usecase.pattern;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

// Итератор для обхода всех элементов контента
class ContentIterator implements Iterator<Content> {

    private final Stack<Content> stack = new Stack<>();

    // Конструктор принимает начальный элемент
    public ContentIterator(List<Content> content) {
        int i = 0;
        while (i < content.size()) {
            Content value = content.get(i);
            stack.push(value);
            List<Content> inners = value.getInners();

        }
    }

    private void pushInners(Content content) {
        List<Content> inners = content.getInners();
        int i = 0;
        while (i < inners.size()) {
            stack.push(inners.get(i));
            pushInners(inners.get(i));
        };
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek() != null) {
                return true;
            } else {
                stack.pop();
            }
        }
        return false;
    }

    @Override
    public Content next() {
        if (hasNext()) {
            Content value = stack.peek();
            return value;
        }
        throw new NoSuchElementException();
    }
}
