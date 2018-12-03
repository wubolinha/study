package com.carboxtech.studymain.mvp.Presenter;

import com.carboxtech.studymain.mvp.Model.MvpModel;
import com.carboxtech.studymain.mvp.Interface.MvpCallback;
import com.carboxtech.studymain.mvp.Interface.MvpView;

/**
 * Created by admin on 2018/11/22.
 *
 *  Presenter类是具体的逻辑业务处理类，该类为纯Java类，不包含任何Android API，
 *  负责请求数据，并对数据请求的反馈进行处理。
 *
 *  之前是在Presenter的构造方法中得到View接口的引用，
 *  现在我们需要修改Presenter引用View接口的方式让View接口与宿主Activity共存亡
 *
 */

public class MvpPresenter extends BasePresenter<MvpView>{


    public void  getData(String   paras){
        if (!isViewAttached()){
            //如果没有View引用就不加载数据
            return;
        }
        getBaseView().showLoading();//显示进度条
        MvpModel.getNetData(paras, new MvpCallback() {

            @Override
            public void onSuccess(Object data) {
                if(isViewAttached()){
                    if(data instanceof  String){
                        getBaseView().showData((String) data);
                    }

                }
            }

            @Override
            public void onFailure(String msg) {
                if(isViewAttached()) {
                    getBaseView().showFailureMessage(msg);
                }
            }

            @Override
            public void onError() {
                // 显示错误信息
                if(isViewAttached()) {
                    getBaseView().showErrorMessage();
                }

            }

            @Override
            public void onComplete() {
                // 数据获取完毕，隐藏进度条
                if(isViewAttached()) {
                    getBaseView().hideLoading();
                }

            }
        });
    }



}
