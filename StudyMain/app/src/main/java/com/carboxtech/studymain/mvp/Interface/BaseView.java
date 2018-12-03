package com.carboxtech.studymain.mvp.Interface;

import android.content.Context;

/**
 * Created by admin on 2018/11/22.
 *
 *  顶级接口view
 */

public interface BaseView {


    // 正在加载
    void   showLoading();

    //隐藏加载条
    void  hideLoading();

    /**
     * 当数据请求失败后，调用此接口提示
     * @param msg 失败原因
     */
    void showFailureMessage(String msg);

    /**
     * 当数据请求异常，调用此接口提示
     */
    void showErrorMessage();

    Context getContext();
}
