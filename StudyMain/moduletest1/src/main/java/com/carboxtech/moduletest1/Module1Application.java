package com.carboxtech.moduletest1;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.carboxtech.modulebase.IModuleApplication;

/**
 * Created by admin on 2018/12/25.
 */

public class Module1Application extends Application implements IModuleApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("test","Module1Application  Application  模块初始化 ");
        try {
            // 如果是 主模块 反射过来的，那就无法获取 context， 如果无异常，那就是组件单独运行
            doInit(this.getApplicationContext());
        }catch (Exception  ex){
            ex.printStackTrace();
        }
    }

    // 如果是 主模块 反射过来的，在这里初始化
    @Override
    public void moduleinit(Context applicationContext) {
        doInit(applicationContext);
    }

    // 实际初始化
    private void doInit(Context context){
        if(context ==null){
            throw new NullPointerException("初始化失败...........");
        }
        Log.w("test","实际初始化  成功 ！ ");
    }
}
