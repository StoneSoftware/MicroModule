package org.springboot.springmvc.mybatis.filter.spring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <Spring注册自定义过滤器>
 * 
 * @author Administrator
 *
 * @since 2019/4/27
 */
@Configuration
public class RegistrationBeanFilter
{
    @Bean
    public FilterRegistrationBean filterRegist()
    {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new SpringCustomizeFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}

/**
 * <Spring自定义的过滤器>
 * 
 * @author Administrator
 * 
 * @since 2019/4/27
 *
 */
class SpringCustomizeFilter implements Filter
{
    
    @Override
    public void destroy()
    {
        // 销毁逻辑
    }
    
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
        FilterChain arg2)
        throws IOException, ServletException
    {
        // 过滤逻辑
    }
    
    @Override
    public void init(FilterConfig arg0)
        throws ServletException
    {
        // 初始化逻辑
    }
    
}
