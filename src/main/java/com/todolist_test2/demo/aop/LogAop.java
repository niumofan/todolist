package com.todolist_test2.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Aspect
@Component
public class LogAop {

    @Pointcut("execution(public * com.todolist_test2.demo.controller.*.*(..))")
    public void Log() {}

    @Before(value = "Log()")
    public void before(JoinPoint jp) {
        System.out.print("进入方法：");
        System.out.println(jp.getSignature().toShortString());

        //获取传入目标方法的参数
        Object[] args = jp.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        System.out.println();
    }
}
