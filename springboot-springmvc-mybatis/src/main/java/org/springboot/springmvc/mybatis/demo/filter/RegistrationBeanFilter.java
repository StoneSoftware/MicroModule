package org.springboot.springmvc.mybatis.demo.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegistrationBeanFilter
{
    @Bean
    public FilterRegistrationBean filterRegist()
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new BeanFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
