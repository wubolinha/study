package com.carboxtech.studymain.dagger2.Base4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.carboxtech.studymain.R;

import junit.framework.Test;

import javax.inject.Inject;
import javax.inject.Named;

public class SecondDaggerActivity extends Activity {


    @Inject
    @Named("phone")
    String phone;

    @Inject
    @Named("computer")
    String computer;

    @Inject
    @Named("TestLazy")   //测试延时加载
    String TestLazy;

    @Inject
    TestSingleton singleton1;
    @Inject
    TestSingleton singleton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_dagger);

        DaggerTestSingletonComponent.create().inject(this);

        String test = "单例测试： hashCode  "+singleton1.hashCode()+"   "
                + singleton2.hashCode()+ phone+"  "+computer+"   "+TestLazy;
        Toast.makeText( this, test,Toast.LENGTH_LONG).show();
    }



}
