package com.base.helper

import android.content.SharedPreferences
import com.google.gson.Gson

/**
 * Created by Burak Eregar on 17.06.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
class SpHelper constructor(var sharedPreferences: SharedPreferences, var gson: Gson) {

    private var editor: SharedPreferences.Editor = sharedPreferences.edit()

//    @Synchronized fun setModel(offlineTourData: YourModel) {
//        putDatatoSharedPref(gson.toJsonTree(offlineTourData, YourModel::class.java)
//                .toString(), String::class.java, "keyForModel")
//
//    }
//
//    @Synchronized fun getModel(): YourModel {
//        return gson.fromJson((getDataFromSharedPref(String::class.java, "savedTours"))
//                as String?, YourModel::class.java)
//    }

    @Synchronized fun <T> getDataFromSharedPref(dataType: Class<T>, key: String): Any? {
        if (dataType == Int::class.java) {
            return sharedPreferences.getInt(key, 0)
        } else if (dataType == String::class.java) {
            return sharedPreferences.getString(key, null)
        } else if (dataType == Long::class.java) {
            return sharedPreferences.getLong(key, 0)
        } else if (dataType == Boolean::class.java) {
            return sharedPreferences.getBoolean(key, false)
        }
        return null
    }

    @Synchronized fun <T> putDatatoSharedPref(data: T, dataType: Class<*>, key: String) {
        if (dataType == Int::class.java) {
            editor.putInt(key, data as Int)
        } else if (dataType == String::class.java) {
            editor.putString(key, data as String)
        } else if (dataType == Long::class.java) {
            editor.putLong(key, data as Long)
        } else if (dataType == Boolean::class.java) {
            editor.putBoolean(key, data as Boolean)
        }
        editor.commit()
    }
}