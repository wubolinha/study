package com.carboxtech.studymain.dagger2.Base4;

import dagger.Lazy;

/**
 * Created by admin on 2018/11/20.
 */

public class TestLazy {

    Lazy<String>  testLazy;

    public  String  getName() {
        return   testLazy.get();
    }
}
