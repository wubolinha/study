package com.carboxtech.studymain.javabase;

import android.util.Log;

/**
 * Created by admin on 2018/11/28.
 *
 *   交替打印　ａｂ
 */

public class PrintTool {

    private boolean flag=true;

    public synchronized  void   outPutA(){

        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        flag= false;
        Log.w("test","  A ");
        notify();

    }

    public synchronized  void   outPutB(){

        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        flag= true;
        Log.w("test","  B ");
        notify();

    }

}
