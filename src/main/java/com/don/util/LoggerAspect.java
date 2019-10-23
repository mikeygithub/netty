package com.don.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ProjectName netty
 * @Author 麦奇
 * @Email biaogejiushibiao@outlook.com
 * @Date 10/16/19 11:20 AM
 * @Version 1.0
 * @Description:日志切面
 **/
@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    public LoggerAspect() {
    }

    /**
     * 切点
     */
    @Pointcut(value = "execution(@Logger * com.don.util.Demo.*(*)))")
    private void pointCut(){ }

    @Before(value = "pointCut()")
    private void beforLog(){
        LOGGER.info("beforLog");
    }
    @Around("pointCut()&&args(name)")
    public Object aroundComplete(ProceedingJoinPoint joinPoint,String name){
        //获取Logger注解参数
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String loggerName = method.getAnnotation(com.don.util.Logger.class).name();
        String loggerTime = method.getAnnotation(com.don.util.Logger.class).time();
        //调用业务代码
        Object result = null;
        try {
            System.out.println("before---around");
            result = joinPoint.proceed();
            System.out.println("after---around");
        }catch (Throwable t){
            t.printStackTrace();
        }
        return result;
    }
}
