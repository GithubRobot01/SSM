package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//指定该类为配置类
@Configuration
//扫描aop包
@ComponentScan("aop")
public class SpringConfig {
}
