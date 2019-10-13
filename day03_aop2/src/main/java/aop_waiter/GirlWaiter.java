package aop_waiter;

public class GirlWaiter implements Waiter {
    public void service() {
        System.out.println("服务...");
    }

    public void maidan() {
        System.out.println("买单...");
    }
}
