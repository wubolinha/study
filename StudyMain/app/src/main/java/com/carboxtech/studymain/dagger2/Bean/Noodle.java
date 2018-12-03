package com.carboxtech.studymain.dagger2.Bean;

import javax.inject.Inject;

/**
 * Created by admin on 2018/11/19.
 *
 * 面条
 */

public class Noodle {

    @Inject  // @Inject 给一个类的构造方法进行注解时，表明了它能提供依赖的能力。
    public Noodle() {
    }

    @Override
    public String toString() {
        return "面条";
    }
}
