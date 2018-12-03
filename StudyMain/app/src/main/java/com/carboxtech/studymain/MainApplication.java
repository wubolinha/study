package com.carboxtech.studymain;

import android.app.Application;

/**
 * Created by admin on 2018/11/28.
 */

public class MainApplication extends Application {

    public static  MainApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }


}
