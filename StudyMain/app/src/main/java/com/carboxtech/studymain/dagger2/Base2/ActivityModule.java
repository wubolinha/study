package com.carboxtech.studymain.dagger2.Base2;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2018/11/19.
 */


@Module
public class ActivityModule {

    @Provides
    public int provideTestvalue(){
        return  10010 ;
    }
}
