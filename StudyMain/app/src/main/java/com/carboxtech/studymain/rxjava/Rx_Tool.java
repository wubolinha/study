package com.carboxtech.studymain.rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by admin on 2018/11/16.
 * <p>
 * 功能操作符
 */

public enum Rx_Tool {

    instance;


    /***********  功能操作符: 延时1s发送事件   *************/
    public void tool_delay() {

        Observable.just("la", "ao")
                .delay(1, TimeUnit.SECONDS)
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

    /************
     *  指定被观察者线程, 要注意的时，如果多次调用此方法，只有第一次有效。
     * **************************/

    public void tool_subscribeOn() {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                // do something
                emitter.onNext("1123");
                emitter.onComplete();
            }
        })
          .subscribeOn(Schedulers.io())  //指定在io线程中运行
          .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {

                    }
                });

    }

/*************
 * 指定观察者的线程，每指定一次就会生效一次。

1, Schedulers.computation( )            用于使用计算任务，如事件循环和回调处理
2, Schedulers.immediate( )              当前线程
3, Schedulers.io( )                     用于 IO 密集型任务，如果异步阻塞 IO 操作。
4, Schedulers.newThread( )              创建一个新的线程
5, AndroidSchedulers.mainThread()       View 的 UI 线程，用于操作 UI。

 * ****************/
    public void  tool_observeOn(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {

            }
        })
          .observeOn( Schedulers.io() )             // 切换观察者线程
          .map(new Function<String, Integer>() {   // map 后的 function 的 运行在 Schedulers.io()
            @Override
            public Integer apply(String s) throws Exception {
                return 111;
            }
          })
           .observeOn(AndroidSchedulers.mainThread() )  // 切换观察者线程
            .subscribe(new Observer<Integer>() {   //  subscribe 运行在 AndroidSchedulers.mainThread()
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


}
