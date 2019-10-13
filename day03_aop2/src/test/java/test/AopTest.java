package test;

import aop.MyAspect;
import aop.TargetInterface;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AopTest {
    @Autowired
    private TargetInterface target;

    @Test
    public void Test1(){
        target.save();
    }
}
