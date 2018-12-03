package com.carboxtech.studymain.dagger2.Base2;

import com.carboxtech.studymain.dagger2.Bean.Baozi;
import com.carboxtech.studymain.dagger2.Bean.Noodle;
import com.carboxtech.studymain.dagger2.Bean.TongyiNoodle;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2018/11/19.
 */

@Module //Dagger2 中规定，用 @Provides 注解的依赖必须存在一个用 @Module 注解的类中。
public class ShangJiaModule {

    String restaurant;   // 模仿 Module 中的 参数传递

    public ShangJiaModule(String restaurant) {   // 注意：构造函数没有被注解
        this.restaurant = restaurant;
    }

    @Provides  //Provide 本身的字面意思就是提供，显然在 Dagger2 中它的作用就是提供依赖。一般针对第三方库
    public Baozi provideBaozi(){

        return new Baozi("豆沙包");  // 方式1：直接用 new 创建了依赖
    }

    @Provides  //Provide 本身的字面意思就是提供，显然在 Dagger2 中它的作用就是提供依赖。一般针对第三方库
    public Noodle provideNoodle(TongyiNoodle tongyi){
     //   return new Noodle();
        return tongyi;   //?  什么时候用 new 关键字？什么时候直接返回传入进来的参数？
        /****
         *
         *  什么时候可以直接返回传入的参数就很明显了:
         *  对于被 @Inject 注解过构造方法或者在一个 Module 中的被 @Provides 注解的方法提供了依赖时，
         *  就可以直接返回传入的参数，而第三方的库或者 SDK 自带的类就必须手动创建了。
         *
         * ****/
    }

    @Provides
    public String provideResturant(){
        return restaurant;
    }


}
