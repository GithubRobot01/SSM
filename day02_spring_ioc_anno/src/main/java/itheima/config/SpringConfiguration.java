package itheima.config;

import org.springframework.context.annotation.*;

//标志该类是Spring的核心配置类
@Configuration
@ComponentScan("itheima")
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
