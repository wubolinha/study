package com.carboxtech.studymain.rxjava;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 2018/11/16.
 * <p>
 * 组合操作符
 */

public enum Rx_Combine {

    instance;

    /**************
     *可以将多个观察者组合在一起，然后按照之前发送顺序发送事件。
     * 需要注意的是，concat() 最多只可以发送4个事件。
     * *****************/
    public void combine_concat() {
        Observable.concat(
                Observable.just(1, 2),
                Observable.just(3, 4),
                Observable.just(5, 6)
        )
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

    /***************
     *
     *  与 concat() 作用一样，不过 concatArray() 可以发送多于 4 个被观察者。
     * *******************************/

    public void combine_concatArray() {
        Observable.concatArray(Observable.just(1, 2),
                Observable.just(3, 4),
                Observable.just(5, 6))
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


    /****************
     * 这个方法月 concat() 作用基本一样，知识 concat() 是串行发送事件，而 merge() 并行发送事件。
     * *********************/

    public void  combine_merge(){
        Observable.merge( Observable.just(1,2),
                Observable.just(3,4),
                Observable.just(5,6))
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


}
