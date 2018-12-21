package com.carboxtech.studymain.mvp.Model;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import com.carboxtech.studymain.mvp.Interface.MvpCallback;

import java.lang.reflect.Method;

/**
 * Created by admin on 2018/11/22.
 *
 *  Model 类中定了具体的网络请求操作。为模拟真实的网络请求，
 *  利用postDelayed方法模拟耗时操作，通过判断请求参数反馈不同的请求状态：
 */

public class MvpModel {


    public static void  getNetData(final String para ,final MvpCallback callback){

             new Handler().postDelayed(new Runnable() {
                 @Override
                 public void run() {
                    switch (para){
                        case "success":
                            callback.onSuccess("根据参数  "+para+"   请求网络数据成功");
                            break;
                        case "failure":
                            callback.onFailure("参数错误");
                            break;
                        case "error":
                            callback.onError();
                            break;
                    }
                    callback.onComplete();
                 }
             },1000) ;

        }
}
