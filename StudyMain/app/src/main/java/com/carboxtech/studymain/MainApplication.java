package com.carboxtech.studymain;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.carboxtech.modulebase.IModuleApplication;

/**
 * Created by admin on 2018/11/28.
 */

public class MainApplication extends Application {

    public static  MainApplication instance;
    public boolean isDebug =true;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;

        if (isDebug) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        Log.w("test","在Application中初始化 ARouter ");
        init_module();
    }

    // 初始化 组件中 的 需要初始化的代码
     String module1Name="com.carboxtech.moduletest1.Module1Application";
     private void  init_module(){
         Log.w("test","init module application");
         try {
             Class<?> clazz = Class.forName(module1Name);
             Object obj = clazz.newInstance();
             if (obj instanceof IModuleApplication){
                 Log.w("test","init Module1Application");
                 ((IModuleApplication) obj).moduleinit(getApplicationContext());
             }

         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (IllegalAccessException e) {
             e.printStackTrace();
         } catch (InstantiationException e) {
             e.printStackTrace();
         }


     }

}
