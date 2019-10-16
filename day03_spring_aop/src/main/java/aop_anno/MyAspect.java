package aop_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect  //该类为切面类
@EnableAspectJAutoProxy
public class MyAspect {
    //定义切点表达式
    @Pointcut("execution(* aop_anno.Target.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        System.out.println("前置增强...");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("后置增强...");
    }

    //ProceedingJoinPoint:正在执行的连接点(切点)
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强...");
        Object proceed=pjp.proceed(); //切点方法
        System.out.println("环绕后增强...");
        return proceed;
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("异常抛出增强...");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("最终增强...");
    }
}
