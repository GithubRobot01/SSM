package myssm.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class ApplicationContextUtil {
    public static ApplicationContext getApplicationContext(ServletContext servletContext) {

        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
