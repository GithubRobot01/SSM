package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
@EnableAspectJAutoProxy //开启自动代理,替换<aop:aspectj-autoproxy></aop:aspectj-autoproxy>-->
public class MyAspect {
    @Before("mypoint()")
    public void before(){
        System.out.println("前置增强");
    }
    public void afterReturing(){
        System.out.println("后置增强");
    }
    public void after(){
        System.out.println("最终增强");
    }
    @Around("execution(* aop.Target.save(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强");
        Object proceed = pjp.proceed();
        System.out.println("环绕后增强");
        return proceed;
    }
    public void afterThrowing(){
        System.out.println("异常增强");
    }
    @Pointcut("execution(* aop.Target.*(..))")
    public void mypoint(){

    }
    @Pointcut("execution(* aop.Target.save(..))")
    public void mypoint2(){

    }
}
