package com.example.javapatternsproject.common.storage.saverimpl;

import android.content.Context;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.rxjava3.RxPreferenceDataStoreBuilder;
import androidx.datastore.rxjava3.RxDataStore;

import com.example.javapatternsproject.common.storage.DataSaver;

import io.reactivex.rxjava3.core.Single;

// Реализация для DataStore
public class DataStoreSaver implements DataSaver {
    private final Preferences.Key<String> dataKey = PreferencesKeys.stringKey("data_key");
    private final RxDataStore<Preferences> dataStore;

    public DataStoreSaver(Context context) {
        this.dataStore = new RxPreferenceDataStoreBuilder(context, "app_datastore").build();;
    }

    @Override
    public void saveString(String key, String value) {
        dataStore.updateDataAsync(prefs -> {
            MutablePreferences mutablePreferences = prefs.toMutablePreferences();
            mutablePreferences.set(PreferencesKeys.stringKey(key), value);
            System.out.println("Data saved in DataStore: " + key + " = " + value);
            return Single.just(mutablePreferences);
        }).subscribe();
    }

    @Override
    public String getString(String key) {
        return dataStore.data()
                .map(prefs -> prefs.get(PreferencesKeys.stringKey(key)))
                .blockingFirst();
    }
}

