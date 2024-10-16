package com.example.javapatternsproject.common.storage;

// Интерфейс для реализации сохранения данных
public interface DataSaver {

    void saveString(String key, String value);

    String getString(String key);
}
