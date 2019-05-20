# Spring MVC & SpringBoot接收参数的几种方式 #
## 一、@RequestParam注解 #
<font color=blue>1.1、 @RequestParam注解用于获取查询参数。例如url?paramName=paramValue这种形式  </font>\
<font color=blue>1.2、 @RequestParam有4个参数， name|value|required|defaultValue;  name与value的效果是等价的; name与value不能共用,只能二选一</font>
``` java
@RestController
@RequestMapping("/rest/test/")
public class Rest
{
    /*
     * SpringMVC4.2之后，RequestParam有4个参数：
     * name|value|required|defaultValue;name与value的效果是等价的;name与value不能共用,只能二选一
     */
    @RequestMapping("/test1")
    public Objecttest1(@RequestParam(name = "paramName", required = false, defaultValue = "") String paramName)
    {
        return null;
    }
}
```
## 二、@PathVariable注解 #
<font color=blue>2.1、 @PathVariable注解用于获取路径参数。例如url/{paramName}这种形式 </font>\
<font color=blue>2.2、 @PathVariable有3个参数：name|value|required; name与value的效果是等价的; name与value不能共用,只能二选一 </font>
``` java
    /*
     *@PathVariable有3个参数：
     * name|value|required;name与value的效果是等价的;name与value不能共用,只能二选一
     */
    @RequestMapping("/test2/{paramName}")
    public Object test2( @PathVariable(name = "paramName", required = false) String paramName)
    {
        return null;
    }
```
## 三、@RequestBody注解 #
<font color=blue>3.1、 @RequestBody注解用于获取POST body请求参数 </font>\
<font color=blue>3.2、 @RequestBody有1个参数：required</font>
``` java
    /*
     *@RequestBody有1个参数：required
     */
    @RequestMapping("/test3")
    public Object test3( @RequestBody(required=false) Object object)
    {
        return null;
    }
```
## 四、@RequestHeader注解 #
<font color=blue>4.1、 @RequestHeader注解用于获取HTTP Header</font>\
<font color=blue>4.2、 @RequestHeader有4个参数：name|value|required|defaultValue;  name与value的效果是等价的; name与value不能共用,只能二选一</font>
```java
    @RequestMapping("/test4")
    public void demo3(@RequestHeader(name = "headerName") String headerName) {
    }
```
## 五、@CookieValue注解 # 
<font color=blue>5.1、 @CookieValue注解用于获取Cookie信息</font>\
<font color=blue>5.2、 @CookieValue有4个参数：name|value|required|defaultValue;  name与value的效果是等价的; name与value不能共用,只能二选一</font>
```java
    @RequestMapping("/test4")
    public void demo3(@CookieValue(name = "cookieName") String cookieName)
    {
    }
```
## 六、HttpServletRequest # 
```java
    @RequestMapping("/test5")
    public void test5(HttpServletRequest request)
    {
        
    }
```