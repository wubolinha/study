package com.carboxtech.studymain.mvp.Presenter;

import com.carboxtech.studymain.mvp.Interface.BaseView;

/**
 * Created by admin on 2018/11/22.
 */

public class BasePresenter<V extends BaseView> {


    public V  baseView;

    public V detachActivity() {
        return this.baseView=null;
    }

    public void  attachActivity(V baseView) {
        this.baseView = baseView;
    }

    public boolean isViewAttached(){
        return this.baseView!= null;
    }

    public V getBaseView() {
        return baseView;
    }
}
