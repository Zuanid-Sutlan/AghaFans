//package com.example.aghafans.utils
//
//import android.content.Context
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.booleanPreferencesKey
//import androidx.datastore.preferences.core.stringPreferencesKey
//import androidx.datastore.preferences.preferencesDataStore
//import kotlinx.coroutines.flow.map
//
//class PrefsManager(var context: Context) {
//
//
//    private val DATASTORE_NAME = "app_prefs"
//    private val IS_DARK_THEME = booleanPreferencesKey("theme")
//
//
//    private val Context.dataStore: DataStore<Preferences> by lazy {
//        this.createDataStore(name = "app_prefs")
//    }
//
//    val isDArkTheme
//        get() = context.datastore.data.map { preferences ->
//            preferences[IS_DARK_THEME]
//        }
//
//
//    companion object {
//        fun getInstance(context: Context) = PrefsManager(context)
//    }
//}