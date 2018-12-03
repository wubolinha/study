package com.carboxtech.studymain.rxjava;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by admin on 2018/11/15.
 *
 * 转换操作符
 *
 */

public enum Rx_Convert {

    instance;


    /*****************   map 可以将被观察者发送的数据类型转变成其他的类型  *********************************/

    public void convert_map(){
        Observable.just(1, 2, 3)
                .map(new Function<Integer, String>() {   // 返回的是 结果集合(多个 Observable)
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "I am "+integer;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });
    }

    /**************** flatMap:  这个方法可以将事件序列中的元素进行整合加工，返回一个新的被观察者。********/
    /****************       返回的数据是无序的          **********************/

    public void convert_flatMap(){
        // flatmap返回的是包含结果集的Observable
        Observable.just(1, 2, 3)
                .flatMap(new Function<Integer, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer integer) throws Exception {
                        List<Integer> list=new ArrayList<>();
                        return  Observable.fromIterable(  list ); // 注意此处和 flat的区别，他返回的是一个包含集合的 Observable
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });
    }

    /***************** concatMap() 和 flatMap() 基本上是一样的，
     * 只不过 concatMap() 转发出来的事件是有序的，
     * 而 flatMap() 是无序的。*************************************/

    public void convert_concatMap(){



    }




}
