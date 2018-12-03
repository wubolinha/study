package com.carboxtech.studymain.dagger2.Base3;

import com.carboxtech.studymain.dagger2.Bean.Car;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2018/11/19.
 */


@Module
public class CarModule {


    @Provides
    public static Car provideGoods(){
        return new Car();
    }

}
