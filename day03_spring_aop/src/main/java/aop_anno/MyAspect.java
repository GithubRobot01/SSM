package aop_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect  //该类为切面类
public class MyAspect {
    //@Before("execution(* aop_anno.Target.*(..))")
    public void before(){
        System.out.println("前置增强...");
    }

    public void afterReturning(){
        System.out.println("后置增强...");
    }

    //ProceedingJoinPoint:正在执行的连接点(切点)
    @Around("MyAspect.pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed=pjp.proceed(); //切点方法
        System.out.println("环绕后增强...");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("异常抛出增强...");
    }

    public void after(){
        System.out.println("最终增强...");
    }

    //定义切点表达式
    @Pointcut("execution(* aop_anno.Target.*(..))")
    public void pointcut(){}
}
