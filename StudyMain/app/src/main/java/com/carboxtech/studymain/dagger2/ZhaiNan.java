package com.carboxtech.studymain.dagger2;

import com.carboxtech.studymain.dagger2.Bean.Baozi;
import com.carboxtech.studymain.dagger2.Bean.Noodle;

import javax.inject.Inject;

/**
 * Created by admin on 2018/11/19.
 *
 *  一个宅男，他喜欢在家玩游戏，所以饿了的时候，他不想自己煮饭吃，也不愿意下楼去餐厅，他选择了外卖。
 */

public class ZhaiNan {

    @Inject  //@Inject 给一个类的相应的属性做标记时，说明了它是一个依赖需求方，需要一些依赖。
            Baozi baozi;

    @Inject  //@Inject 给一个类的相应的属性做标记时，说明了它是一个依赖需求方，需要一些依赖。
            Noodle noodle;

    @Inject    //@Inject 给一个类的构造方法进行注解时，表明了它能提供依赖的能力。
    public ZhaiNan() {

    }

    @Inject
    String resturant;  //餐厅名字

    public String eat(){
        StringBuilder sb=new StringBuilder();
        sb.append("吃的是： ");
        if(resturant!=null){
            sb.append( resturant );
        }
        if( baozi!=null ){
            sb.append(" "+ baozi.toString() );
        }
        if( noodle!=null ){
            sb.append( "  "+noodle.toString() );
        }
       return  sb.toString();
    }



}
