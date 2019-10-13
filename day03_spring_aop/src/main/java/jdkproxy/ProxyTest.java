package jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        final Target target=new Target();
        final Advice advice=new Advice();

        TargetInterface proxy_target = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标对象类加载器
                target.getClass().getInterfaces(), //目标对象相同的接口字节码对象数组
                new InvocationHandler() {
                    //调用代理对象的任何方法,实质执行的都是invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        method.invoke(target, args);
                        advice.after();
                        return null;
                    }
                });

        proxy_target.save();
    }

}
