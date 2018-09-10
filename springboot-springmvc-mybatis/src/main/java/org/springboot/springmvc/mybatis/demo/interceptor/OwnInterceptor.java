package org.springboot.springmvc.mybatis.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class OwnInterceptor implements HandlerInterceptor
{
    
    /**
     * 进入controller层之前拦截请求
     * 
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o)
        throws Exception
    {
        
        System.out.println("---------------------开始进入请求地址拦截----------------------------");
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o,
        ModelAndView modelAndView)
        throws Exception
    {
        System.out.println("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
        HttpServletResponse httpServletResponse, Object o, Exception e)
        throws Exception
    {
        System.out.println("---------------视图渲染之后的操作-------------------------0");
    }
}
