package com.carboxtech.studymain.dagger2.Bean;

import javax.inject.Inject;

/**
 * Created by admin on 2018/11/19.
 *
 *  包子
 */

public class Baozi {

    String name="小笼包";

    @Inject   //@Inject 给一个类的构造方法进行注解时，表明了它能提供依赖的能力。
    public Baozi() {
    }

    public Baozi(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
