package com.carboxtech.studymain.javabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.carboxtech.studymain.R;
import com.carboxtech.studymain.tool.AssetsTool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/********
 *
 * java 进程与线程
 *
 * *******/

public class JavaThreadTestActivity extends AppCompatActivity {

    private Button javabasebt1,javabasebt2;
    private TextView showInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_base_test);

        javabasebt1 = (Button) findViewById(R.id.javabasebt1);
        javabasebt1.setText("交替输出ａｂ");
        javabasebt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrintAB();
            }
        });

        showInfo = (TextView) findViewById(R.id.showInfo);
        showInfo.setText(    AssetsTool.getText("java并发.txt",this)  );

        javabasebt2 = (Button) findViewById(R.id.javabasebt2);
        javabasebt2.setText("Callable 配合　FutureTask　　获取线程执行后的结果");
        javabasebt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callableDemo();
            }
        });
    }

   //交替输出ａｂ
    private void  PrintAB(){

        final PrintTool printTool=new PrintTool();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    printTool.outPutA();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    printTool.outPutB();
                }

            }
        }).start();

    }

    private void  callableDemo(){
        CallableThread callableThread=new CallableThread();
        //  1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<String> futureTask=new FutureTask<String>(callableThread);
        new Thread( futureTask ).start();

        try {
            String  result= futureTask.get();  // futureTask.get会阻塞直达获取结果
            Toast.makeText(JavaThreadTestActivity.this,"futureTask.get会阻塞直达获取结果： "+result,Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
