package aop;

public class Target implements TargetInterface {
    public void save() {
        /*System.out.println(1/0);*/
        System.out.println("save...running...");
    }
}
