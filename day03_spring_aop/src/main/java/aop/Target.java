package aop;

public class Target implements TargetInterface {
    public void method() {
        /*System.out.println(1/0);*/
        System.out.println("Target...running...");
    }
}
