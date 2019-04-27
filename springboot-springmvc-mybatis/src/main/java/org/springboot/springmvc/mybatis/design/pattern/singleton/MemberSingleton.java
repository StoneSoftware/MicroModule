package org.springboot.springmvc.mybatis.design.pattern.singleton;

final class MemberSingleton
{
    // 2.饿汉式实例化对象
    private final static MemberSingleton INSTANCE = new MemberSingleton();
    
    private MemberSingleton()
    {
        // 1.私有化构造器
    }
    
    public static MemberSingleton getInstance()
    {
        // 3.提供外部获取单例对象的静态方法
        return INSTANCE;
    }
}
