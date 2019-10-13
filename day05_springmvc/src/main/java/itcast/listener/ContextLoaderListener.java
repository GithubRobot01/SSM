package itcast.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        //读取web.xml中的全局参数
        String contextConfig = servletContext.getInitParameter("contextConfig");

        ApplicationContext app=new ClassPathXmlApplicationContext(contextConfig);
        //将spring的应用上下文对象存储到ServletContext域中
        ApplicationContextUtil.getApplicationContext(servletContext );
        System.out.println("spring容器创建完毕...");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
