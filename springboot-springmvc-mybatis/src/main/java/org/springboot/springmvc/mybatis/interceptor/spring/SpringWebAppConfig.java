package org.springboot.springmvc.mybatis.interceptor.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * 注册拦截器 Created by SYSTEM on 2017/8/16.
 */
public class SpringWebAppConfig extends WebMvcConfigurerAdapter
{
    
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new OwnInterceptor())
        // 添加拦截路径
            .addPathPatterns("api/path/**")
            // 排除拦截路径
            .excludePathPatterns("api/path/login");
    }
}

class OwnInterceptor implements HandlerInterceptor
{
    
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o)
        throws Exception
    {
        
        // 开始进入请求地址拦截逻辑
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o,
        ModelAndView modelAndView)
        throws Exception
    {
        // 处理请求完成后视图渲染之前的处理操作逻辑
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o, Exception e)
        throws Exception
    {
        // 视图渲染之后的操作逻辑
    }
}