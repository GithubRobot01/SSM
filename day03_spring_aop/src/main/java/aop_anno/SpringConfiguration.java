package aop_anno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //配置该类为spring的核心配置类
@ComponentScan("aop_anno") //指定spring在初始化容器时要扫描com.springboot包及其子包
public class SpringConfiguration {
}
