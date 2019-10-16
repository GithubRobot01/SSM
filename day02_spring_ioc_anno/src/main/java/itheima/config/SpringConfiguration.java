package itheima.config;

import org.springframework.context.annotation.*;


@Configuration //标志该类是Spring的核心配置类
@ComponentScan("itheima") //指定spring在初始化容器时要扫描cn.edu.ncwu包及其子包
@Import(DataSourceConfiguration.class) //导入DataSourceConfiguration配置类
public class SpringConfiguration {

}
