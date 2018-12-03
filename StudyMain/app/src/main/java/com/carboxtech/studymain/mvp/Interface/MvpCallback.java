package com.carboxtech.studymain.mvp.Interface;

/**
 * Created by admin on 2018/11/22.
 *
 *   为了不限制传入的参数类型，这里使用泛型
 */

public interface MvpCallback<T> {

    void  onSuccess(T  data);

    void  onFailure(String  msg);

    void onError();

    void  onComplete();

}
