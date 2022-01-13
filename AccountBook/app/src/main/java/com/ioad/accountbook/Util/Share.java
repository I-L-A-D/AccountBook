package com.ioad.accountbook.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class Share {

    public static final String PREFERENCES_NAME = "rebuild_preference";
    private static final String DEFAULT_VALUE_STRING = "";
    private static final int DEFAULT_VALUE_INT = -1;

    private static SharedPreferences getPreference(Context mContext) {
        return (SharedPreferences) mContext.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public static void setString(Context mContext, String key, String value) {
        SharedPreferences prefs = getPreference(mContext);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void setInt(Context mContext, String key, int value) {
        SharedPreferences prefs = getPreference(mContext);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static String getString(Context mContext, String key) {
        SharedPreferences prefs = getPreference(mContext);
        String value = prefs.getString(key, DEFAULT_VALUE_STRING);
        return value;
    }

    public static int getInt(Context mContext, String key) {
        SharedPreferences prefs = getPreference(mContext);
        int value = prefs.getInt(key, DEFAULT_VALUE_INT);
        return value;
    }

}
