package org.springboot.springmvc.mybatis;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/test/")
public class Rest
{
    /*
     * SpringMVC4.2之后，RequestParam有4个参数：
     * name|value|required|defaultValue;name与value的效果是等价的;name与value不能共用,只能二选一
     */
    @RequestMapping("/test1")
    public Object test1(
        @RequestParam(name = "paramName", required = false, defaultValue = "") String paramName)
    {
        return null;
    }
    
    /*
     * @PathVariable有3个参数：
     * name|value|required;name与value的效果是等价的;name与value不能共用,只能二选一
     */
    @RequestMapping("/test2/{paramName}")
    public Object test2(
        @PathVariable(name = "paramName", required = false) String paramName)
    {
        return null;
    }
    
    /*
     * @RequestBody有1个参数：required
     */
    @RequestMapping("/test3")
    public Object test3(@RequestBody(required = false) Object object)
    {
        return null;
    }
    
    @RequestMapping("/test4")
    public void test4(@CookieValue(name = "cookieName") String cookieName)
    {
    }
    
    @RequestMapping("/test5")
    public void test5(HttpServletRequest request)
    {
        
    }
    
}
