package com.example.javapatternsproject.common.storage.storageimpl;

import com.example.javapatternsproject.common.storage.DataSaver;
import com.example.javapatternsproject.common.storage.DataStorage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DebugDataStorage extends DataStorage {

    public DebugDataStorage(DataSaver dataSaver) {
        super(dataSaver);
    }

    @Override
    public void saveString(String key, String value) {
        Logger.getAnonymousLogger().log(Level.ALL, value);
        super.saveString(key, value);
    }

    @Override
    public String getString(String key) {
        Logger.getAnonymousLogger().log(Level.ALL, key);
        return super.getString(key);
    }
}
