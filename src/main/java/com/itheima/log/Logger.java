package com.itheima.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 管理日志类
 *
 * 记录：在执行方法前，记录执行了什么方法
 *      执行方02
 *      执行方法中呼唤就会
 *创建分啊
 */
public class Logger {


    /**
     * 常用：环绕增强:需要指定代理的方法什么时候执行
     */
    public void around(ProceedingJoinPoint joinPoint){

        //执行代理的方法
        try {
            System.out.println("前置增强");
            joinPoint.proceed();
            System.out.println("返回值之前增强");
        } catch (Throwable throwable) {
            System.out.println("出现异常后增强");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终增强");
        }
    }


    /**
     * 在执行某方法之前，记录一些内容
     *
     * JoinPoint  joinPoint: 连接点 , 
     */
    public void before(JoinPoint joinPoint){
        //代理对象
        Object target = joinPoint.getTarget();
        String className = target.getClass().getName();
//        获取方法对象
        String methodName = joinPoint.getSignature().getName();
        System.out.println("拦截的方法："+className+"."+methodName);
        System.out.println("在执行业务层方法之前执行before");
    }

    public void afterReturning(JoinPoint joinPoint){
        System.out.println("返回值之前执行");
    }

    public void  after(JoinPoint joinPoint){
        System.out.println("最终增强");
    }

    public void afterThrowing(JoinPoint joinPoint){
        System.out.println("出现的异常的时候执行");
    }


}
