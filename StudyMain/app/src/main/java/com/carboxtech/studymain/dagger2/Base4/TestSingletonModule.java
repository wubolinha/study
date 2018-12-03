package com.carboxtech.studymain.dagger2.Base4;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2018/11/20.
 */


@Module
public class TestSingletonModule {

    @Provides
    @Singleton
    TestSingleton provideTestSingleton(){
        return new TestSingleton();
    }

    /****
     *
     *  在一个 Module 中 @Provides 提供的依赖是由返回值决定的。这样就会出现问题，同一种类型不同实例，怎么去区别？
     *
     *   那就是 使用   @Named
     * ****/
    @Provides
    @Named("phone")
    public  String providePhone(){
        return "手机";
    }

    @Provides
    @Named("computer")
    public  String provideComputer(){
        return "电脑";
    }

    @Provides
    @Named("TestLazy")
    public String getLazy(){

        return "TestLazy";
    }


}
