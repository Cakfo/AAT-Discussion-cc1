package com.spaja.aatdiscussionscc1;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Spaja on 26-Oct-17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
