package com.example.javapatternsproject.common.ui.animation

import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator

// Задание 14 - Паттерн Proxy

// Интерфейс для анимации expand
interface ExpandAnimation {
    fun expand(view: View, targetHeight: Int)
}

// Проксируемый класс - Анимация с увеличением размера
class RealExpandAnimation : ExpandAnimation {
    override fun expand(view: View, targetHeight: Int) {
        // Анимация изменения высоты View до целевого размера
        val initialHeight = view.height
        val animator = ValueAnimator.ofInt(initialHeight, targetHeight)
        animator.duration = 300
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.addUpdateListener { animation ->
            val newHeight = animation.animatedValue as Int
            val layoutParams = view.layoutParams
            layoutParams.height = newHeight
            view.layoutParams = layoutParams
        }
        animator.start()
    }
}

// Класс Proxy для анимации expand
class ExpandAnimationProxy(private val realAnimation: RealExpandAnimation) : ExpandAnimation {
    override fun expand(view: View, targetHeight: Int) {
        if (shouldAnimate()) {
            // Выполняем анимацию
            realAnimation.expand(view, targetHeight)
        } else {
            // Изменение размера без анимации
            val layoutParams = view.layoutParams
            layoutParams.height = targetHeight
            view.layoutParams = layoutParams
        }
    }

    // Метод для определения, нужна ли анимация
    private fun shouldAnimate(): Boolean {
        // Пример условия: анимация выполняется только если включён режим разработчика
        return isDebugMode()
    }

    // Проверка режима (пример проверки)
    private fun isDebugMode(): Boolean {
        // Здесь можно добавить логику для определения режима
        return true  // Например, в дебаг-режиме включаем анимацию
    }
}

// Использование прокси в Android приложении
fun expandView(view: View, targetHeight: Int) {
    val realAnimation = RealExpandAnimation()
    val animationProxy = ExpandAnimationProxy(realAnimation)

    // Вызов прокси, который либо выполнит анимацию, либо просто изменит размер
    animationProxy.expand(view, targetHeight)
}