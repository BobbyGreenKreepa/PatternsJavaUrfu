package com.example.javapatternsproject.common.ui.text.textpresent;

import android.graphics.Typeface;
import android.text.Spannable;

import java.util.List;

public class SpannableTextPresent extends TextPresent {

    private final List<Spannable> spans;

    public SpannableTextPresent(Typeface typeface, String value, PresentType presentType, List<Spannable> spannables) {
        super(typeface, value, presentType);
        this.spans = spannables;
    }

    public List<Spannable> getSpans() {
        return spans;
    }
}
