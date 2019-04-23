##### Java中的异步处理\
一、Spring内置的@Async
在spring 3.x之后，Spring内置了@Async来解决异步问题，基于@Async标注的方法，称之为异步方法，这些方法在执行的时候，会在独立的线程中被执行，调用者无需等待它的完成，\
即可继续其他后续操作。在Spring中，基于Java配置的方式启用@Async的步骤：\
1、开启异步配置：
	` @Configuration                                  `
	` @EnableAsync                                    `  
	` public class App                                `
	` {                                               `
	`    public static void main(String[] args)       `
	`    {                                            `
	`        SpringApplication.run(App.class, args);  `
	`    }                                            `
	`                                                 `
	` }                                               `
 

4. 基于@Async无返回值调用

使用的方式非常简单，一个标注即可解决所有的问题：

1 @Async  //标注使用  
2 public void asyncMethodWithVoidReturnType() {  
3     System.out.println("Execute method asynchronously. "  
4       + Thread.currentThread().getName());  
5 }  
5. 基于@Async返回值的调用

复制代码
 1 @Async  
 2 public Future<String> asyncMethodWithReturnType() {  
 3     System.out.println("Execute method asynchronously - "  + Thread.currentThread().getName());  
 4     try {  
 5         Thread.sleep(5000);  
 6         return new AsyncResult<String>("hello world !!!!");  
 7     } catch (InterruptedException e) {  
 8         //  
 9     }  
10    
11     return null;  
12 }  
复制代码
  以上示例可以发现，返回的数据类型为Future类型，其为一个接口。具体的结果类型为AsyncResult,这个是需要注意的地方。

 调用返回结果的异步方法示例

复制代码
 1 public void testAsyncAnnotationForMethodsWithReturnType()  
 2    throws InterruptedException, ExecutionException {  
 3     System.out.println("Invoking an asynchronous method. "   + Thread.currentThread().getName());  
 4     Future<String> future = asyncAnnotationExample.asyncMethodWithReturnType();  
 5    
 6     while (true) {  ///这里使用了循环判断，等待获取结果信息  
 7         if (future.isDone()) {  //判断是否执行完毕  
 8             System.out.println("Result from asynchronous process - " + future.get());  
 9             break;  
10         }  
11         System.out.println("Continue doing something else. ");  
12         Thread.sleep(1000);  
13     }  
14 }  
复制代码
这些获取异步方法的结果信息，是通过不停的检查Future的状态来获取当前的异步方法是否执行完毕来实现的。

 

6. 基于@Async调用中的异常处理机制

 在异步方法中，如果出现异常，对于调用者caller而言，是无法感知的。如果确实需要进行异常处理，则按照如下方法来进行处理：

    1.  自定义实现AsyncTaskExecutor的任务执行器

         在这里定义处理具体异常的逻辑和方式。

    2.  配置由自定义的TaskExecutor替代内置的任务执行器

    示例步骤1，自定义的TaskExecutor

 

复制代码
 1 public class ExceptionHandlingAsyncTaskExecutor implements AsyncTaskExecutor {  
 2     private AsyncTaskExecutor executor;  
 3     public ExceptionHandlingAsyncTaskExecutor(AsyncTaskExecutor executor) {  
 4         this.executor = executor;  
 5      }  
 6       ////用独立的线程来包装，@Async其本质就是如此  
 7     public void execute(Runnable task) {       
 8       executor.execute(createWrappedRunnable(task));  
 9     }  
10     public void execute(Runnable task, long startTimeout) {  
11         /用独立的线程来包装，@Async其本质就是如此  
12        executor.execute(createWrappedRunnable(task), startTimeout);           
13     }   
14     public Future submit(Runnable task) { return executor.submit(createWrappedRunnable(task));  
15        //用独立的线程来包装，@Async其本质就是如此。  
16     }   
17     public Future submit(final Callable task) {  
18       //用独立的线程来包装，@Async其本质就是如此。  
19        return executor.submit(createCallable(task));   
20     }   
21       
22     private Callable createCallable(final Callable task) {   
23         return new Callable() {   
24             public T call() throws Exception {   
25                  try {   
26                      return task.call();   
27                  } catch (Exception ex) {   
28                      handle(ex);   
29                      throw ex;   
30                    }   
31                  }   
32         };   
33     }  
34   
35     private Runnable createWrappedRunnable(final Runnable task) {   
36          return new Runnable() {   
37              public void run() {   
38                  try {  
39                      task.run();   
40                   } catch (Exception ex) {   
41                      handle(ex);   
42                    }   
43             }  
44         };   
45     }   
46     private void handle(Exception ex) {  
47       //具体的异常逻辑处理的地方  
48       System.err.println("Error during @Async execution: " + ex);  
49     }  
50 }
复制代码
 分析： 可以发现其是实现了AsyncTaskExecutor, 用独立的线程来执行具体的每个方法操作。在createCallable和createWrapperRunnable中，定义了异常的处理方式和机制。

 handle()就是未来我们需要关注的异常处理的地方。 配置文件中的内容：

1 <task:annotation-driven executor="exceptionHandlingTaskExecutor" scheduler="defaultTaskScheduler" />  
2 <bean id="exceptionHandlingTaskExecutor" class="nl.jborsje.blog.examples.ExceptionHandlingAsyncTaskExecutor">  
3     <constructor-arg ref="defaultTaskExecutor" />  
4 </bean>  
5 <task:executor id="defaultTaskExecutor" pool-size="5" />  
6 <task:scheduler id="defaultTaskScheduler" pool-size="1" />  
 

7. @Async调用中的事务处理机制

    在@Async标注的方法，同时也适用了@Transactional进行了标注；在其调用数据库操作之时，将无法产生事务管理的控制，原因就在于其是基于异步处理的操作。

     那该如何给这些操作添加事务管理呢？可以将需要事务管理操作的方法放置到异步方法内部，在内部被调用的方法上添加@Transactional.

    例如：  方法A，使用了@Async/@Transactional来标注，但是无法产生事务控制的目的。

          方法B，使用了@Async来标注，  B中调用了C、D，C/D分别使用@Transactional做了标注，则可实现事务控制的目的。