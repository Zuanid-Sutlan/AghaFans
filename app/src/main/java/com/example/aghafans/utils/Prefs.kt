package com.example.aghafans.utils

import android.preference.PreferenceManager
import com.example.aghafans.MainActivity

object Prefs {


    private val sharedPreference = PreferenceManager.getDefaultSharedPreferences(MainActivity.appContext)

    @JvmStatic
    var isDarkTheme : Boolean
        get() = sharedPreference.getBoolean("isDarkTheme", false)
        set(isDarkTheme){
            sharedPreference.edit().putBoolean("isDarkTheme",isDarkTheme).apply()
        }

    var savedFilePath : String?
        get() = sharedPreference.getString("path", "null")
        set(path){
            sharedPreference.edit().putString("path",path).apply()
        }

    var firstTime: Boolean
        get() = sharedPreference.getBoolean("firstTime", true)
        set(value) {
            sharedPreference.edit().putBoolean("firstTime", value).apply()
        }




}