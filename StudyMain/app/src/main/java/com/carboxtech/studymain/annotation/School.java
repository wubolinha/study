package com.carboxtech.studymain.annotation;

import android.util.Log;

import junit.framework.Test;

import java.lang.reflect.Field;

/**
 * Created by admin on 2018/12/26.
 *
 *    一个学习，包含了 学生，老师，工人 ，售货员
 */

public class School {

    @People(name = "xiaohua" , sex = "girl" , age = 25)
    String student;

    @People(name = "wanglaoshi" ,sex = "boy" ,age = 50)
    String teacher;

    @People(name = "agang" ,sex = "man" ,age = 30)
    String worker;

    @People(name = "meimei" ,sex = "woman" ,age = 40)
    String salesman;


    public static  void initValue(){

        // 判断类是否应用了某个注解( 对类的注解才有效 )
        boolean isAnnotation = School.class.isAnnotationPresent( People.class );

        Log.w("test","本类是否应用了注解 People.class ：  "+ isAnnotation);

        try {
            // 判断属性是否使用了注解
            Field field = School.class.getDeclaredField("student");
            field.setAccessible(true);
            isAnnotation = field.isAnnotationPresent( People.class);
            Log.w("test","属性 student 是否应用了注解 People.class ：  "+ isAnnotation);
            if(isAnnotation){
                People people = field.getAnnotation(  People.class);
                Log.w("test","注解属性值  ：  "+ people.name()+"  "+people.sex()+"  "+people.age());
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }


}
