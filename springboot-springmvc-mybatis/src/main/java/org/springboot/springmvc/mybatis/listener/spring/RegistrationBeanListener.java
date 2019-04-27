package org.springboot.springmvc.mybatis.listener.spring;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Administrator
 *
 * @since 2019/4/27
 */
@Configuration
public class RegistrationBeanListener
{
    @Bean
    public ServletListenerRegistrationBean<SpringOwnListener> servletListenerRegistrationBean()
    {
        ServletListenerRegistrationBean<SpringOwnListener> listenerRegistration =
            new ServletListenerRegistrationBean<SpringOwnListener>();
        listenerRegistration.setListener(new SpringOwnListener());
        return listenerRegistration;
    }
}

/**
 * <自定义监听器>
 * 
 * @author Administrator
 * 
 * @since 2019/4/27
 *
 */
class SpringOwnListener implements ServletContextListener
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