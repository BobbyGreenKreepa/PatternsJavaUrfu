package com.example.javapatternsproject.common.ui.animation;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

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
