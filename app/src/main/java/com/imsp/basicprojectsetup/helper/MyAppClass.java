package com.imsp.basicprojectsetup.helper;

import android.app.Application;

/**
 * Created by SP on 03-04-2017.
 */

public class MyAppClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyInit.init(this);
    }
}
