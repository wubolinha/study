package com.carboxtech.studymain.javabase;

/**
 * Created by admin on 2018/12/14.
 */

public enum Week {  //枚举类 , 继承 java.lang.Enum  ，这个类的构造方法是 private

    Monday,   // 枚举对象,枚举对象都是static final的类对象
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;


    @Override
    public String toString() {
        return super.toString();
    }



}
