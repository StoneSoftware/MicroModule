package org.springboot.springmvc.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

//@SpringBootApplication(@Configuration, @EnableAutoConfiguration and @ComponentScan)
//标记我SpringBoot应用
@SpringBootApplication
// 使用@MapperScan注解通过使用@MapperScan可以指定要扫描的Mapper类的包的路径
// 使用@Mapper注解为了让DemoMapper能够让别的类进行引用,我们可以在DemMapper类上添加@Mapper注解
@MapperScan("org.springboot.springmvc.mybatis.*.mapper")
// 开启异步执行
@EnableAsync
// 开启权限认证
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
