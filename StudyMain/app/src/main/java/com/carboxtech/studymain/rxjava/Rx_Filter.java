package com.carboxtech.studymain.rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/**
 * Created by admin on 2018/11/16.
 *
 *   过滤操作符
 *
 */

public enum Rx_Filter {

    instance;

    /*************
     *  通过一定逻辑来过滤被观察者发送的事件，如果返回 true 则会发送事件，否则不会发送。
     * *********************/
    public void   filter_filter(){

        Observable.just(1,2,3)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer < 2;  // 小于2，发送事件
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });
    }

/**************
 *  过滤事件序列中的重复事件
 * *************************/

    public void  filter_distinct(){

        Observable.just(1,3,5,6,2,2,4,5,6)
                .distinct()   //过滤事件序列中的重复事件。
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });


    }

    /*********
     *
     * 如果两件事件发送的时间间隔小于设定的时间间隔则前一件事件就不会发送给观察者, 用于按键去抖动
     * *********/
    public void  filter_debounce(){

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

            }
        })
                .debounce(1, TimeUnit.SECONDS)  // 去抖动
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });
    }


}
