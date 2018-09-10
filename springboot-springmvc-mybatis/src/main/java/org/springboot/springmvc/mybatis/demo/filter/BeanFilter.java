package org.springboot.springmvc.mybatis.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BeanFilter implements Filter
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
