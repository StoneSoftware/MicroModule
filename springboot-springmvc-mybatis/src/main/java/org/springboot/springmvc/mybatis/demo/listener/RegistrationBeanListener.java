package org.springboot.springmvc.mybatis.demo.listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistrationBeanListener
{
    @Bean
    public ServletListenerRegistrationBean<BeanListener> servletListenerRegistrationBean()
    {
        ServletListenerRegistrationBean<BeanListener> slrBean =
            new ServletListenerRegistrationBean<BeanListener>();
        slrBean.setListener(new BeanListener());
        return slrBean;
    }
}
