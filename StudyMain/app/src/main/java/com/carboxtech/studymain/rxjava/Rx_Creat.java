package com.carboxtech.studymain.rxjava;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by admin on 2018/11/15.
 * <p>
 * 被观察者创建方式：
 * <p>
 * 观察者类型：
 * new Observer，
 * new Consumer
 * <p>
 * 订阅方式：
 * subscribe;
 */

public enum Rx_Creat {
    instance;

    String TAG = "RX_Creat";

    /************************** 普通创建* ********************************/
    public void creat_normal() {
        creat_Observable(); //  创建被观察者：
        creat_Observer();   // 创建观察者
        bind();             // 订阅
    }

    private Observable observable;
    private Observer observer;

    //  创建被观察者：
    private void creat_Observable() {
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onComplete();
            }
        });
    }

    // 创建观察者
    private void creat_Observer() {
        observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    // 订阅
    private void bind() {
        observable.subscribe(observer);
    }

    /**************************链式创建*********************************/

    void creat_chain() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d(TAG, "creat_chain ---> " + "subscribe");
                emitter.onNext("你好");
                Log.d(TAG, "creat_chain ---> " + " emitter 你好");
                emitter.onNext("中国");
                Log.d(TAG, "creat_chain ---> " + " emitter 中国");
                emitter.onComplete();
                Log.d(TAG, "creat_chain ---> " + " emitter onComplete");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "creat_chain ---> " + "onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "creat_chain ---> " + "onNext  " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "creat_chain ---> " + "onError  " + e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "creat_chain ---> " + "onComplete");
            }
        });
    }

    /***********************  使用 just 操作符创建 ************************************/
    void creat_just() {
        //  创建一个被观察者，并发送事件，发送的事件不可以超过10个以上
        Observable.just(100, 200, 300)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /*********************** 使用 fromArray  创建   *****************************************/
    void creat_fromArray() {
        //  这个方法和 just() 类似，只不过 fromArray 可以传入多于10个的变量，并且可以传入一个数组
        Integer array[] = {10, 20, 30, 40};
        Observable.fromArray().subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /*******************   fromIterable() 直接发送一个 List 集合数据给观察者    ************************/
    List<String> list=new ArrayList<>();

    public void  creat_fromIterable(){
        list.add(  "a" );
        list.add(  "b" );
        list.add(  "c" );
        list.add(  "d" );
        list.add(  "e" );
        Observable.fromIterable(  list )
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    /************************* 使用 fromCallable 返回对于值给观察者 ，  Consumer是简易版的Observer, ********************************/

    void creat_fromCallable() {
        //  这里的 Callable 是 java.util.concurrent 中的 Callable，Callable 和 Runnable 的用法基本一致，只是它会返回一个结果值，这个结果值就是发给观察者的。
        Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 0;
            }
        }).subscribe(new Consumer<Integer>() {  //   Consumer是简易版的Observer,
            @Override
            public void accept(Integer integer) throws Exception {

            }
        });

    }

    /************     使用  fromFuture 创建，是可以  cancle   的 fromCallable      ********/
    FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
        @Override
        public String call() throws Exception {
            return "返回结果";
        }
    });

    public void creat_fromFuture() {
        Observable.fromFuture(futureTask)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        futureTask.run();
                        // futureTask.cancel(true);   // 可取消
                    }
                })
                .subscribe(new Consumer<String>() {            // 事件可以连续订阅
                    @Override
                    public void accept(String s) throws Exception {
                        //
                    }
                });
    }

/*********************** timer  定时器 , 当到指定时间后就会发送一个  值给观察者*********************/
    public void  creat_timer(){

        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                    }
                });

    }

/****************  interval():   每隔一段时间就会发送一个事件，  *************************/

    public void creat_interval(){
        // 每 4s 时间就会发送一个事件
        Observable.interval( 4 , TimeUnit.SECONDS )
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                    }
                });

    }

    // 按照其他参数要求 每隔一段时间发生事件
    public void creat_intervalRange(){
        // 从 2 开始， 发送5次 ，延时 1 s ， 每隔 1s 发送一次
        Observable.intervalRange(2,5,1,1,TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {

            }
        });

    }

    /***************** range :同时发送一定范围的事件序列  **********************/

    public void creat_range(){

        Observable.range(0,10)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                    }
                });

    }



}
