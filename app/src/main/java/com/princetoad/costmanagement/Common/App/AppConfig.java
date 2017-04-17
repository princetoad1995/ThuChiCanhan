package com.princetoad.costmanagement.Common.App;

import android.app.Application;
import android.content.Context;

import com.princetoad.costmanagement.Common.Database.DatabaseHelper;
import com.princetoad.costmanagement.ServiceImpl.SharedPreferencesServiceImpl;

/**
 * Created by PRINCE D. TOAD on 4/17/2017.
 */

public class AppConfig extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesServiceImpl.init(this);
        DatabaseHelper.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
