package com.carboxtech.studymain.dagger2.Base2;


import com.carboxtech.studymain.dagger2.TestDaggerActivity;
import com.carboxtech.studymain.dagger2.ZhaiNan;

import junit.framework.Test;

import dagger.Component;

/**
 * Created by admin on 2018/11/19.
 */

@Component(modules = {ShangJiaModule.class ,ActivityModule.class }  )
public interface WaiMaiPlatformComponent {

    ZhaiNan waimai();   // 注入方式1： 返回类型

    void zhuru(ZhaiNan zhaiNan); // 注入方式2：在 方法中传入类型参数。目的是针对这个参数对象进行依赖注入。

    void inject(TestDaggerActivity  testDaggerActivity); // 类似注入方式2  。
}
