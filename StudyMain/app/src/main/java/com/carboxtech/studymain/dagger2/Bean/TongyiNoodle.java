package com.carboxtech.studymain.dagger2.Bean;

import javax.inject.Inject;

/**
 * Created by admin on 2018/11/19.
 *  统一方便面
 */

public class TongyiNoodle extends Noodle {

    @Inject
    public TongyiNoodle() {
    }

    @Override
    public String toString() {
        return "统一方便面";
    }
}
