package com.example.javapatternsproject.common.ui.text.textpresent;

import android.graphics.Typeface;

import org.w3c.dom.Text;

abstract public class TextPresent {

    private final Typeface typeface;

    private final String value;

    private final PresentType presentType;

    public TextPresent (
            Typeface typeface,
            String value,
            PresentType presentType
    ) {
        this.typeface = typeface;
        this.value = value;
        this.presentType = presentType;
    }

    public PresentType getPresentType() {
        return presentType;
    }

    public String getValue() {
        return value;
    }

    public Typeface getTypeface() {
        return typeface;
    }
}
