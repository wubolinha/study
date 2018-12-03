package com.carboxtech.studymain.javabase;

import java.util.concurrent.Callable;

/**
 * Created by admin on 2018/11/29.
 */

public class CallableThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "我爱你一万年";
    }
}
