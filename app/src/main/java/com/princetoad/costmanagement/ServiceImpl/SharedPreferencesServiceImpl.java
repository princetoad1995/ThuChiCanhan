package com.princetoad.costmanagement.ServiceImpl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.princetoad.costmanagement.Service.SharedPreferencesService;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public class SharedPreferencesServiceImpl implements SharedPreferencesService{
    private final SharedPreferences sharedPreferences;
    private static final String CONFIGURATION_NAME = "WWCOM_CONFIG";
    private static  SharedPreferencesServiceImpl instance;

    private final String FIRST_TIME = "my_first_time";

    public SharedPreferencesServiceImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(CONFIGURATION_NAME, Activity.MODE_PRIVATE);
    }

    public static void init(Context context){
        if (instance != null){

        }
        instance = new SharedPreferencesServiceImpl(context);
    }

    public static SharedPreferencesServiceImpl getInstance(){
        if (instance == null){
            throw new RuntimeException();
        }
        return instance;
    }

    @Override
    public boolean isFirstTime() {
        if (!sharedPreferences.getBoolean(FIRST_TIME, false)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(FIRST_TIME, true);
            editor.commit();
            return true;
        }
        return false;
    }

    @Override
    public void saveObject(String key, Object value) {
        if (getObject(key, value.getClass()) != null) {
            remove(key);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        editor.putString(key, json);
        editor.commit();
    }

    @Override
    public <T> Object getObject(String key, Class<T> a) {
        Gson gson = new Gson();
        String dValue = sharedPreferences.getString(key, "");
        return gson.fromJson(dValue, a);
    }

    @Override
    public void remove(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }
}
