package com.carboxtech.studymain.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.carboxtech.studymain.R;

/**********
 *
 *
 *
       可用于代替 Handler  sendMessage
 *   参考：  https://juejin.im/post/5b17560e6fb9a01e2862246f
 *



 * *********/

public class Test1Activity extends AppCompatActivity {

    String TAG = "Test1ctivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1ctivity);

        //  被观察者创建方式：
        Rx_Creat.instance.creat_normal();// 普通创建
        Rx_Creat.instance.creat_chain();//链式创建
        Rx_Creat.instance.creat_just();//使用 just 操作符创建
        Rx_Creat.instance.creat_fromArray();// 使用 fromArray  创建
        Rx_Creat.instance.creat_fromIterable();//fromIterable() 直接发送一个 List 集合数据给观察者
        Rx_Creat.instance.creat_fromCallable();//使用 fromCallable 返回对于值给观察者 ，  Consumer是简易版的Observer
        Rx_Creat.instance.creat_fromFuture();//使用  fromFuture 创建，是可以  cancle   的 fromCallable
        Rx_Creat.instance.creat_timer();//timer  定时器 , 当到指定时间后就会发送一个  值给观察者
        Rx_Creat.instance.creat_interval();// 每隔一段时间就会发送一个事件
        Rx_Creat.instance.creat_intervalRange();//按照其他参数要求 每隔一段时间发生事件
        Rx_Creat.instance.creat_range();//同时发送一定范围的事件序列


        // 转换操作符
        Rx_Convert.instance.convert_map();// map 可以将被观察者发送的数据类型转变成其他的类型
        Rx_Convert.instance.convert_flatMap();//flatMap:  这个方法可以将事件序列中的元素进行整合加工，返回一个新的包含集合的被观察者
        Rx_Convert.instance.convert_concatMap();//oncatMap() 和 flatMap() 基本上是一样的，只不过 concatMap() 转发出来的事件是有序的，


        // 组合操作符
        Rx_Combine.instance.combine_concat();//可以将多个观察者组合在一起，然后按照之前发送顺序发送事件。
        Rx_Combine.instance.combine_concatArray();//与 concat() 作用一样，不过 concatArray() 可以发送多于 4 个被观察者。
        Rx_Combine.instance.combine_merge();//这个方法月 concat() 作用基本一样，知识 concat() 是串行发送事件，而 merge() 并行发送事件。

        //功能操作符
        Rx_Tool.instance.tool_delay();//指定被观察者线程, 要注意的时，如果多次调用此方法，只有第一次有效。
        Rx_Tool.instance.tool_subscribeOn();//
        Rx_Tool.instance.tool_observeOn();// 指定观察者的线程，每指定一次就会生效一次。

        // 过滤操作符
        Rx_Filter.instance.filter_filter();// 通过一定逻辑来过滤被观察者发送的事件，如果返回 true 则会发送事件，否则不会发送
        Rx_Filter.instance.filter_distinct();  //过滤事件序列中的重复事件
        Rx_Filter.instance.filter_debounce();// 如果两件事件发送的时间间隔小于设定的时间间隔则前一件事件就不会发送给观察者, 用于按键去抖动



    }




}
