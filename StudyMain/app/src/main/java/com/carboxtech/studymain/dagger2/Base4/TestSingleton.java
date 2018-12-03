package com.carboxtech.studymain.dagger2.Base4;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by admin on 2018/11/20.
 */


@Singleton   //用 @Singleton 标注在目标单例上
public class TestSingleton {

    @Inject
    public TestSingleton() {

    }

}
