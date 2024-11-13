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
