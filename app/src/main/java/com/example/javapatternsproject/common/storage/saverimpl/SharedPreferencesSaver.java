package com.example.javapatternsproject.common.storage.saverimpl;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.javapatternsproject.common.storage.DataSaver;

// Реализация для SharedPreferences
public class SharedPreferencesSaver implements DataSaver {
    private final SharedPreferences sharedPreferences;

    public SharedPreferencesSaver(Context context) {
        sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
    }

    @Override
    public void saveString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
        System.out.println("Data saved in SharedPreferences: " + key + " = " + value);
    }

    @Override
    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }
}

