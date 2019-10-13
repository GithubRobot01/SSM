package cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {
    public static void main(final String[] args) {
        final Target target=new Target();
        final Advice advice=new Advice();

        //1.创建增强器
        Enhancer enhancer=new Enhancer();
        //2.设置父类(目标)
        enhancer.setSuperclass(Target.class);
        //3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                method.invoke(target,args);
                advice.after();
                return null;
            }
        });

        //创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }

}
