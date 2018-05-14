package org.springboot.springmvc.mybatis.async;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * <实现异步执行> 
 * <@Async 所修饰的函数不要定义为static,这样异步调用不会生效>
 * 
 * @author Administrator
 *
 */
@Component
public class Task {

	@Async
	public Future<String> task1() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("task1");
		return new AsyncResult<String>("task1");
	}

	@Async
	public Future<String> task2() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("task2");
		return new AsyncResult<String>("task2");
	}

	@Async
	public Future<String> task3() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("task3");
		return new AsyncResult<String>("task3");
	}

}
