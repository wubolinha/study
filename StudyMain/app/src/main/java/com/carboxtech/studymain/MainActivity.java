package com.carboxtech.studymain;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.carboxtech.studymain.algorithm.AlgorithmActivity;
import com.carboxtech.studymain.androidBase.AndroidBaseActivity;
import com.carboxtech.studymain.animation.AnimationActivity;
import com.carboxtech.studymain.aspectJ.DebugTool;
import com.carboxtech.studymain.dagger2.TestDaggerActivity;
import com.carboxtech.studymain.javabase.JavaBaseTestActivity;
import com.carboxtech.studymain.javabase.JavaThreadTestActivity;
import com.carboxtech.studymain.mvp.MvpTestActivity;
import com.carboxtech.studymain.network.NetworkActivity;
import com.carboxtech.studymain.rn.RNActivity;

import java.lang.reflect.Method;

public class MainActivity extends Activity {

    private ListView listview;
    private String[] data;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);
        initListView();

        try {
            testAop();
            testAnnotation(  123);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 测试 aspectJ  的 Advise
    private void testAop() throws InterruptedException {

        Log.w("test","testAop  睡觉了 ");
//        for(int i=0;i<10;i++){
//            Thread.sleep(100);
//        }
        Log.w("test","testAop  起床了 ");
    }
    // 测试 aspectJ 自定义注解
    @DebugTool
    private void testAnnotation( int value ) throws InterruptedException {

        Log.w("test","testAnnotation   测试自定义注解 "+value);
//        for(int i=0;i<40;i++){
//            Thread.sleep(100);
//        }

        Handler handler=new Handler();


    }



    private void initListView() {

        data = getResources().getStringArray(R.array.knowledge);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startAty(i);
               // Toast.makeText(MainActivity.this, "You have selected " + data[i], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void  startAty(int i ){
        Intent intent=new Intent();
        Log.w("test","list item:  "+data[i]);
        switch (data[i]){
            case "Dagger2":
                intent.setClass(this, TestDaggerActivity.class);
                break;
            case "MVP":

                intent.setClass(this, MvpTestActivity.class);
                break;

            case "Android中的3种动画":
                intent.setClass(this, AnimationActivity.class);
                break;
            case "Java并发":
                intent.setClass(this, JavaThreadTestActivity.class);
                break;
            case "Java基础":
                intent.setClass(this, JavaBaseTestActivity.class);
                break;
            case "网络":
                intent.setClass(this, NetworkActivity.class);
                break;
            case "RN开发":
                intent.setClass(this, RNActivity.class);
                break;
            case "算法":
                intent.setClass(this, AlgorithmActivity.class);
                break;
            case "Android基础":
                intent.setClass(this, AndroidBaseActivity.class);
                break;
        }
        try {
            startActivity( intent );
        }catch (Exception ex){
            ex.printStackTrace();
        }



    }




}
