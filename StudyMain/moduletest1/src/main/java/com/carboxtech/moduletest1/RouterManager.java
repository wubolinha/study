package com.carboxtech.moduletest1;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by admin on 2018/12/24.
 */

public enum RouterManager {

  instance;


    public static final String  TestDaggerActivity="/test/TestDaggerActivity";
    public static final String  Module1MainActivity="/test/Module1MainActivity";

    public void injectActivity(Activity activity){

    }

    public void  jumpActivity(Context context, final String path){
        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
        Log.w("test","应用内简单的跳转:  "+path);
        ARouter.getInstance().build(path).navigation(context, new NavigationCallback() {
            @Override
            public void onFound(Postcard postcard) {
                Log.w("test","跳转 : "+path + " onFound "+  postcard.toString());
            }

            @Override
            public void onLost(Postcard postcard) {
                Log.w("test","跳转 : "+path + " onLost "+  postcard.toString());
            }

            @Override
            public void onArrival(Postcard postcard) {
                Log.w("test","跳转 : "+path + " onArrival "+  postcard.toString());
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                Log.w("test","跳转 : "+path + " onInterrupt "+  postcard.toString());
            }
        });

    }




}
