package dev.khoand.pg_app_version_1.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by khoam on 2/26/2018.
 */

public class SharedPrefUtils {
    public static String SHARED_FILE_NAME = "CEsE7Y6DOfnDKsysrEe1";
    public static String USERNAME_KEY = "n4Bi2gJnQLQNlapk9vzh";
    public static String PASSWORD_KEY = "VeTdYfu2TybPVjIBS7na";

    private Context context;

    public SharedPrefUtils (Context context) {
        this.context = context;
    }

    public boolean setValue(String key, String value) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public boolean setValue(String key, boolean value) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public boolean setValue(String key, float value) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    public boolean setValue(String key, int value) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public boolean setValue(String key, long value) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public String getStringValue(String key) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        return pref.getString(key, "");
    }

    public boolean getBooleanValue(String key) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        return pref.getBoolean(key, false);
    }

    public float getFloatValue(String key) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        return pref.getFloat(key, 0);
    }

    public long getLongValue(String key) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        return pref.getLong(key, 0);
    }

    public int getIntValue(String key) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        return pref.getInt(key, 0);
    }

    public boolean removeValue(String key) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        return editor.commit();
    }

    public boolean isExist(String key) {
        SharedPreferences pref = context.getSharedPreferences(SharedPrefUtils.SHARED_FILE_NAME, context.MODE_PRIVATE);
        return pref.contains(key);
    }
}
