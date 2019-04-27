package org.springboot.springmvc.mybatis.listener.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletAnnotationListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        
    }
}
