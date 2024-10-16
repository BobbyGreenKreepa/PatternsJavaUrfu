package com.example.javapatternsproject.common.storage;

// Абстракция для хранения данных
public class DataStorage {
    protected DataSaver dataSaver;

    public DataStorage(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }

    public void saveString(String key, String value) {
        dataSaver.saveString(key, value);
    }

    public String getString(String key) {
        return dataSaver.getString(key);
    }
}
