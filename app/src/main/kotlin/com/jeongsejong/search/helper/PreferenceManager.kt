package com.jeongsejong.search.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle


class PreferenceManager  constructor(private val mContext: Context) {

    private val sharedPreferences: SharedPreferences? = mContext.getSharedPreferences("moa", Activity.MODE_PRIVATE)

    fun clear() {
        if (this.sharedPreferences != null) {
            sharedPreferences.edit().clear().apply()
        }
    }

    fun putString(key: String, value: String) {
        val editor = sharedPreferences!!.edit()
        editor.putString(key, value).apply()
    }

    fun putBoolean(key: String, value: Boolean) {
        val editor = sharedPreferences!!.edit()
        editor.putBoolean(key, value).apply()
    }

    fun putInt(key: String, value: Int) {
        val editor = sharedPreferences!!.edit()
        editor.putInt(key, value).apply()
    }

    fun putFloat(key: String, value: Float) {
        val editor = sharedPreferences!!.edit()
        editor.putFloat(key, value).apply()
    }

    fun putLong(key: String, value: Long) {
        val editor = sharedPreferences!!.edit()
        editor.putLong(key, value).apply()
    }

    private fun put(bundle: Bundle) {
        val editor = sharedPreferences!!.edit()
        val keySet = bundle.keySet().iterator()

        while (keySet.hasNext()) {
            val key = keySet.next()
            val obj = bundle.get(key)

            when (obj) {
                is Boolean -> editor.putBoolean(key, bundle.getBoolean(key))
                is Int -> editor.putInt(key, bundle.getInt(key))
                is String -> editor.putString(key, bundle.getString(key))
            }
        }

        editor.apply()
    }

    fun getString(key: String, defValue: String): String? {
        return sharedPreferences!!.getString(key, defValue)
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return sharedPreferences!!.getBoolean(key, defValue)
    }

    fun getInt(key: String, defValue: Int): Int {
        return sharedPreferences!!.getInt(key, defValue)
    }

    fun getFloat(key: String, defValue: Float): Float {
        return sharedPreferences!!.getFloat(key, defValue)
    }

    fun getLong(key: String, defValue: Long): Long {
        return sharedPreferences!!.getLong(key, defValue)
    }

}
