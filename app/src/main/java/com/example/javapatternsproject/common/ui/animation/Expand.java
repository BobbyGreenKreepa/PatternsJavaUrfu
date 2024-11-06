package com.example.javapatternsproject.common.ui.animation;
// Задание 14 - Паттерн Proxy

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

// Интерфейс для анимации expand
public interface ExpandAnimation {
    void expand(View view, int targetHeight);
}

// Проксируемый класс - Анимация с увеличением размера
public class RealExpandAnimation implements ExpandAnimation {

    @Override
    public void expand(View view, int targetHeight) {
        // Анимация изменения высоты View до целевого размера
        int initialHeight = view.getHeight();
        ValueAnimator animator = ValueAnimator.ofInt(initialHeight, targetHeight);
        animator.setDuration(300);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(animation -> {
            int newHeight = (int) animation.getAnimatedValue();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = newHeight;
            view.setLayoutParams(layoutParams);
        });
        animator.start();
    }
}

// Класс Proxy для анимации expand
public class ExpandAnimationProxy implements ExpandAnimation {

    private final RealExpandAnimation realAnimation;

    public ExpandAnimationProxy(RealExpandAnimation realAnimation) {
        this.realAnimation = realAnimation;
    }

    @Override
    public void expand(View view, int targetHeight) {
        if (shouldAnimate()) {
            // Выполняем анимацию через реальный класс
            realAnimation.expand(view, targetHeight);
        } else {
            // Изменение размера без анимации
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = targetHeight;
            view.setLayoutParams(layoutParams);
        }
    }

    // Метод для определения, нужна ли анимация
    private boolean shouldAnimate() {
        // Пример условия: анимация включается только в режиме разработки
        return isDebugMode();
    }

    // Проверка, находимся ли в режиме разработки (здесь можно добавить свою логику)
    private boolean isDebugMode() {
    return false;
    }
}