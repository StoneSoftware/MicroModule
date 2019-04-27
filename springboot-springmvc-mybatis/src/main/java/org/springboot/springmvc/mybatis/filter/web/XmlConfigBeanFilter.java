package org.springboot.springmvc.mybatis.filter.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * web.xml配置过滤器 1.声明一个类,实现接口Filter 2.在web.xml配置该过滤器
 * 
 * @author Administrator
 *
 */
public class XmlConfigBeanFilter implements Filter
{
    
    @Override
    public void destroy()
    {
        
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
        FilterChain chain)
        throws IOException, ServletException
    {
        System.out.println("通过注册到FilterRegistrationBean配置的过滤器");
        chain.doFilter(req, res);
    }
    
    @Override
    public void init(FilterConfig arg0)
        throws ServletException
    {
        
    }
    
}
