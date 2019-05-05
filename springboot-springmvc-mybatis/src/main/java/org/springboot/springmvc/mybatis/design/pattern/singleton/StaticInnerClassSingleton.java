package org.springboot.springmvc.mybatis.design.pattern.singleton;

/**
 * <静态内部类实现懒汉模式单例>
 * 
 * @author Administrator
 * 
 * @since 2019/4/27
 *
 */
public final class StaticInnerClassSingleton
{
    
    private StaticInnerClassSingleton()
    {
        // 1.私有化构造器
    }
    
    // 2.声明静态内部类,实现懒汉模式获取对象
    public static class StaticInnerClass
    {
        private static final StaticInnerClassSingleton SINGLETON =
            new StaticInnerClassSingleton();
    }
    
    public static StaticInnerClassSingleton getInstance()
    {
        // 3.提供外部获取单例对象的静态方法
        return StaticInnerClass.SINGLETON;
    }
}