package com.carboxtech.studymain.dagger2.Base3;

import com.carboxtech.studymain.dagger2.Bean.Car;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2018/11/
 *
 *  演示 Component 的创建方式方法2：使用 .create();
 *  但是它有一个前提，这个前提就是 Component 中的 module 中被
 *  @Provides 注解的方法都必须是静态方法，也就是它们必须都被 static 修饰。
 */

@Component(modules = CarModule.class)
public interface CarFunctionComponent {

        Car  testCreat();


}
