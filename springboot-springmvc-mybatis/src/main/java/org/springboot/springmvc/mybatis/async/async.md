# Java中的异步处理
## 一、Spring内置的@Async
在spring 3.x之后，Spring内置了@Async来解决异步问题，基于@Async标注的方法，称之为异步方法，这些方法在执行的时候，会在独立的线程中被执行，调用者无需等待它的完成，即可继续其他后续操作。在Spring中，基于Java配置的方式启用@Async的步骤：
### 1、开启异步配置：\
	` @Configuration                                  `\
	` @EnableAsync                                    `\
	` public class App                                `\
	` {                                               `\
	`    public static void main(String[] args)       `\
	`    {                                            `\
	`        SpringApplication.run(App.class, args);  `\
	`    }                                            `\
	`                                                 `\
	` }                                               `    
	                                        
### 2、@Async注解需要异步执行的方法：
	`@Component`\
	`public class Task`\
	`{`\    
	`    @Async`\
	`    public Future<String> task1()`\
	`    {`\
	`        try`\
	`        {`\
	`            Thread.sleep(5000);`\
	`        }`\
	`        catch (InterruptedException e)`\
	`        {`\
	`            e.printStackTrace();`\
	`        }`\
	`        System.err.println("task1");`\
	`        return new AsyncResult<String>("task1");`\
	`    }`\
	`    @Async`\
	`    public Future<String> task2()`\
	`    {`\
	`        try`\
	`        {`\
	`            Thread.sleep(5000);`\
	`        }`\
	`        catch (InterruptedException e)`\
	`        {`\
	`            e.printStackTrace();`\
	`        }`\
	`        System.err.println("task2");`\
	`        return new AsyncResult<String>("task2");`\
	`    }`\
	`}`  
	
### 3、获取异步执行结果：
	`@Resource`\
	`private Task task;`\
	`@Test`\
	`public void test1() {`\
	`	Future<String> f1 = task.task1();`\
	`	Future<String> f2 = task.task2();`\
	`	Future<String> f3 = task.task3();`\
	`	while (true) {`\
	`		if (f1.isDone() && f2.isDone() && f3.isDone()) {`\
	`			System.out.println("全部执行完毕");`\
	`			break;`\
	`		}`\
	`	}`\
	`	System.err.println("Ok");`\
	`}`                                 