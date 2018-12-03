package com.carboxtech.studymain.dagger2.Base4;

import android.app.Activity;

import com.carboxtech.studymain.dagger2.Base2.ActivityModule;
import com.carboxtech.studymain.dagger2.TestDaggerActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by admin on 2018/11/20.
 *
 *   dagger2 单例测试
 */

@Singleton    //然后用 @Singleton 标注在 Component 对象上。
@Component(modules = TestSingletonModule.class)
public interface TestSingletonComponent {



   public  void inject(SecondDaggerActivity activity);


}
