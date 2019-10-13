package aop_waiter;

public class MyAspect {
    public void before(){
        System.out.println("微笑...");
    }
    public void afterReturning(){
        System.out.println("欢迎光临!");
    }
    public void after(){
        System.out.println("欢迎下次再来!");
    }
}
