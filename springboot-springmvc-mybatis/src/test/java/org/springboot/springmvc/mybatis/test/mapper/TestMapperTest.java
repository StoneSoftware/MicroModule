package org.springboot.springmvc.mybatis.test.mapper;

import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.springmvc.mybatis.async.Task;
import org.springboot.springmvc.mybatis.test.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//标记为SpringBoot测试
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMapperTest {

	@Resource
	private ITestMapper testMapper;

	@Resource
	private Task task;

	@Test
	public void test() {
		User user = testMapper.getUser(1);
		System.err.println(user.getName());
	}

	@Test
	public void test1() {
		Future<String> f1 = task.task1();
		Future<String> f2 = task.task2();
		Future<String> f3 = task.task3();
		while (true) {
			if (f1.isDone() && f2.isDone() && f3.isDone()) {
				System.out.println("全部执行完毕");
				break;
			}
		}
		System.err.println("Ok");
	}
}
