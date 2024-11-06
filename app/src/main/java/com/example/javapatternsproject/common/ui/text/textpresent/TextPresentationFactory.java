package com.example.javapatternsproject.common.ui.text.textpresent;

import android.graphics.Typeface;
import android.text.Spannable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kotlin.Triple;

public class TextPresentationFactory {

    private final Map<Triple<String, Typeface, PresentType>, TextPresent> presets = new HashMap<>();

    TextPresent create(String value, Typeface typeface, PresentType type, List<Spannable> spans) {
        if (spans != null) {
            return new SpannableTextPresent(typeface, value, type, spans);
        }

        Triple<String, Typeface, PresentType> triple = new Triple<>(value, typeface, type);

        if (presets.get(triple) != null) {
            return presets.get(triple);
        }

        presets.put(triple, new TextPresent(typeface, value, type));
        return presets.get(triple);
    }
}
