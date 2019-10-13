package aop_anno;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {
    public void save() {
        /*System.out.println(1/0);*/
        System.out.println("save...running...");
    }
}
