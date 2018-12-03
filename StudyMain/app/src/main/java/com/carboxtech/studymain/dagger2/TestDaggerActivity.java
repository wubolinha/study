package com.carboxtech.studymain.dagger2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.carboxtech.studymain.MainActivity;
import com.carboxtech.studymain.R;
import com.carboxtech.studymain.dagger2.Base1.DaggerPlatformComponent;
import com.carboxtech.studymain.dagger2.Base2.DaggerWaiMaiPlatformComponent;
import com.carboxtech.studymain.dagger2.Base2.ShangJiaModule;
import com.carboxtech.studymain.dagger2.Base2.WaiMaiPlatformComponent;
import com.carboxtech.studymain.dagger2.Base3.CarFunctionComponent;
import com.carboxtech.studymain.dagger2.Base3.DaggerCarFunctionComponent;
import com.carboxtech.studymain.dagger2.Base4.DaggerTestSingletonComponent;
import com.carboxtech.studymain.dagger2.Base4.SecondDaggerActivity;
import com.carboxtech.studymain.dagger2.Base4.TestSingleton;
import com.carboxtech.studymain.dagger2.Base4.TestSingletonComponent;
import com.carboxtech.studymain.dagger2.Bean.Car;

import javax.inject.Inject;


/***********
 *
 *  轻松学，听说你还没有搞懂 Dagger2:
 *   https://blog.csdn.net/briblue/article/details/75578459
 *
 *
 **********/
public class TestDaggerActivity extends AppCompatActivity {

    Button daggerbt1,daggerbt2,daggerbt3,daggerbt4,daggerbt5,daggerbt6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dagger);
        daggerbt1= (Button) findViewById(R.id.daggerbt1);
        daggerbt1.setText(" inject  Component");
        daggerbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test1();
            }
        });

        daggerbt2= (Button) findViewById(R.id.daggerbt2);
        daggerbt2.setText(" provide module");
        daggerbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test2();
            }
        });

        daggerbt3= (Button) findViewById(R.id.daggerbt3);
        daggerbt3.setText("zhuru 对象");
        daggerbt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test3();
            }
        });

        daggerbt4= (Button) findViewById(R.id.daggerbt4);
        daggerbt4.setText("inject Activity");
        daggerbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test4();
            }
        });

        daggerbt5= (Button) findViewById(R.id.daggerbt5);
        daggerbt5.setText("使用 create() 而不是 builder  创建 Component");
        daggerbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test5();
            }
        });

        daggerbt6= (Button) findViewById(R.id.daggerbt6);
        daggerbt6.setText(" ingleton  标注");
        daggerbt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test6();
            }
        });

    }

    // inject  Component
    private void  test1(){
        ZhaiNan bolin = DaggerPlatformComponent.builder()
                .shangJiaModule(new ShangJiaModule("湖南一品香"))
                .build().waimai();
        Toast.makeText(this,bolin.eat(),Toast.LENGTH_SHORT).show();
    }

    // provide module
    private void test2(){
        ZhaiNan wo= DaggerWaiMaiPlatformComponent.builder()
                .shangJiaModule(new ShangJiaModule("王小二外卖店"))
                .build().waimai();
        Toast.makeText(this,wo.eat(),Toast.LENGTH_SHORT).show();
    }

    final ZhaiNan zhaiNan = new ZhaiNan();
    private void  test3(){
        WaiMaiPlatformComponent waiMaiPlatformComponent=DaggerWaiMaiPlatformComponent
                .builder()
                .shangJiaModule(new ShangJiaModule("肯德基"))
                .build();
        waiMaiPlatformComponent.zhuru( zhaiNan);
        Toast.makeText(this,zhaiNan.eat(),Toast.LENGTH_SHORT).show();
    }

    @Inject
    int testvalue;
    private void  test4(){

        WaiMaiPlatformComponent waiMaiPlatformComponent=DaggerWaiMaiPlatformComponent
                .builder()
                .shangJiaModule(new ShangJiaModule("北方菜"))
                .build();
        waiMaiPlatformComponent.inject( this);
        Toast.makeText( this,"testvalue is "+ testvalue,Toast.LENGTH_LONG).show();
    }

    private void  test5() {
        CarFunctionComponent carFunctionComponent=DaggerCarFunctionComponent.create();
        Car car= carFunctionComponent.testCreat();
        Toast.makeText( this,car.toString(),Toast.LENGTH_LONG).show();
    }


    //  同一个 Component 获得的 单例是同一个，  TestSingleton是单例的，但是 TestSingletonComponent 不是单例的
    // 不同 的 TestSingletonComponent 生产的对象不一样
    private void  test6() {
//        TestSingletonComponent  testSingletonComponent= DaggerTestSingletonComponent.create();
//        TestSingleton singleton1 = testSingletonComponent.getsingleton();
//        TestSingleton singleton2 = testSingletonComponent.getsingleton();
//        Toast.makeText( this,"单例测试： hashCode  "+singleton1.hashCode()+"   "+ singleton2.hashCode() ,Toast.LENGTH_LONG).show();
//
        Intent intent = new Intent(this, SecondDaggerActivity.class);
        startActivity( intent );
    }




}
