package org.springboot.springmvc.mybatis.listener.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * <web.xml配置监听器> 1.声明一个类，实现ServletContextListener接口 2.web.xml配置监听器
 * 
 * @author Administrator
 * 
 * @since 2019/4/27
 *
 */
public class ServletBeanListener implements ServletContextListener
{
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0)
    {
        
    }
    
    @Override
    public void contextInitialized(ServletContextEvent arg0)
    {
        
    }
    
}
