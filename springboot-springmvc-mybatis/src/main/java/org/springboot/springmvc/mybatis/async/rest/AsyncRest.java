package org.springboot.springmvc.mybatis.async.rest;

import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.springboot.springmvc.mybatis.async.spring.AnnotationSpringAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <异步测试REST>
 * 
 * @author Administrator
 * 
 * @since 2019/4/27
 *
 */
@RestController
@RequestMapping("/async/")
public class AsyncRest
{
    @Resource
    private AnnotationSpringAsync annotationSpringAsync;
    
    @GetMapping("spring/annotation")
    public String test()
    {
        Future<String> async1 = annotationSpringAsync.task1();
        Future<String> async2 = annotationSpringAsync.task2();
        Future<String> async3 = annotationSpringAsync.task3();
        while (true)
        {
            if (async1.isDone() && async2.isDone() && async3.isDone())
            {
                return "async1 + async2 + async3 finished";
            }
        }
    }
}
