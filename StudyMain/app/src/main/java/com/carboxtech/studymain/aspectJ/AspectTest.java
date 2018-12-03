package com.carboxtech.studymain.aspectJ;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * https://blog.csdn.net/eclipsexys/article/details/54425414
 * <p>
 * Join Points: 能插入代码的地方
 */


@Aspect
public class AspectTest {

    /*
    (* android.app.Activity.on**(..))：这个是最重要的表达式，第一个『*』表示返回值，
    『*』表示返回值为任意类型，后面这个就是典型的包名路径，其中可以包含『*』来进行通配，
    几个『*』没区别。同时，这里可以通过『&&、||、!』来进行条件组合。
    ()代表这个方法的参数，你可以指定类型，例如android.os.Bundle，
    或者(..)这样来代表任意类型、任意个数的参数。

     */
    @Before("execution(* android.app.Activity.on**(..))") //Advice： Before
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {  // 实际切入的代码
        String key = joinPoint.getSignature().toString();
        Log.w("test", "Before : " + key);
    }


    @After("execution(* android.app.Activity.on**(..))") // Advice： After
    public void onActivityMethodAfter(JoinPoint joinPoint) throws Throwable {  // 实际切入的代码
        String key = joinPoint.getSignature().toString();
        Log.w("test", "After : " + key);
    }

   // Around和After是不能同时作用在同一个方法上的，会产生重复切入的问题。
    @Around("execution(* com.carboxtech.studymain.MainActivity.testAop() )") // Advice： Around
    public void onMethodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {  // 实际切入的代码
        String key = proceedingJoinPoint.getSignature().toString();
        long start =System.currentTimeMillis();
        Log.w("test1", "onActivityMethodAroundFirst: " + key);
        proceedingJoinPoint.proceed();          //  执行原始代码
        Log.w("test1", "onActivityMethodAroundSecond: " + key);
        long end =System.currentTimeMillis();

        Log.w("test1", "time cost  " + (  end-start )+"  ms" );
    }


    // 处理自定义注解： 创建自己的切入文件,路径为 注解的路径
    @Pointcut("execution(@com.carboxtech.studymain.aspectJ.DebugTool * *(..))")
    public void DebugToolMethod() {

    }

    @Around("DebugToolMethod()")
    public void onDebugToolMethodBefore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start =System.currentTimeMillis();
        proceedingJoinPoint.proceed();          //  执行原始代码
        long end =System.currentTimeMillis();
        Log.w("test1", "DebugToolMethod time cost  " + (  end-start )+"  ms" );

    }



}
