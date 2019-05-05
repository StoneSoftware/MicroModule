package org.springboot.springmvc.mybatis.security.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <Test Rest>
 * 
 * @author wu_firefox@163.com
 *
 */
@RestController
@RequestMapping("/rest/security/")
public class SecurityRest
{
    /**
     * <获取token入口,后续访问需要带上这儿返回的token>
     * 
     * @return String
     */
    @GetMapping("login")
    public String test()
    {
        return "login";
    }
    
    @GetMapping("admin/t1")
    public String test1()
    {
        return "test1";
    }
    
    @GetMapping("admin/t2")
    public String test2()
    {
        return "test2";
    }
    
    @GetMapping("admin/t3")
    public String test3()
    {
        return "test3";
    }
}
