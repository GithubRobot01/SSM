package test;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class aa {
    public static void main(String[] args) {
        final Target target = new Target(); //创建目标对象
        Enhancer enhancer = new Enhancer();   //创建增强器
        enhancer.setSuperclass(Target.class);//设置父类
        enhancer.setCallback(new MethodInterceptor() { //设置回调
            public Object intercept(Object o, Method method, Object[] objects,
                                    MethodProxy methodProxy) throws Throwable {
                System.out.println("前置代码增强....");
                Object invoke = method.invoke(target, objects);
                System.out.println("后置代码增强....");
                return invoke;
            }
        });
        Target proxy = (Target) enhancer.create(); //创建代理对象
        proxy.method();
    }
}
