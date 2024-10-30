package com.example.javapatternsproject.common.ui.text.textpresent;

import android.graphics.Typeface;
import android.text.Spannable;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

        if (presets.get(Triple(value, typeface, type)) != null) {
            return presets.get(Triple(value, typeface, type)
        }

        presets.put(Triple(value, typeface, type), TextPresent(value, typeface, type));
        return presets.get(Triple(value, typeface, type));
    }
}
