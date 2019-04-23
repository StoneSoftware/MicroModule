##### Java中的异步处理
一、Spring内置的@Async
在spring 3.x之后，Spring内置了@Async来解决异步问题，基于@Async标注的方法，称之为异步方法，这些方法在执行的时候，会在独立的线程中被执行，调用者无需等待它的完成，\
即可继续其他后续操作。在Spring中，基于Java配置的方式启用@Async的步骤：\
1、开启异步配置：\
	` @Configuration                                  `\
	` @EnableAsync                                    `\
	` public class App                                `\
	` {                                               `\
	`    public static void main(String[] args)       `\
	`    {                                            `\
	`        SpringApplication.run(App.class, args);  `\
	`    }                                            `\
	`                                                 `\
	` }                                               `\